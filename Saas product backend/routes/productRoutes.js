const express = require('express');
const axios = require('axios');
const Product = require('../models/Product'); // Import Product model

const router = express.Router();

// Get all products
router.get('/products', async (req, res) => {
  try {
    const products = await Product.find();
    res.status(200).json(products);
  } catch (error) {
    console.error('Error fetching products:', error.message);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Get a specific product by ID
router.get('/products/:productId', async (req, res) => {
  const { productId } = req.params;

  try {
    const product = await Product.findById(productId);
    if (!product) {
      return res.status(404).json({ error: 'Product not found' });
    }

    res.status(200).json(product);
  } catch (error) {
    console.error('Error fetching product:', error.message);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Create a new product
router.post('/products', async (req, res) => {
  const { productName, productDescription, price, availabilityStatus } = req.body;

  try {
    const newProduct = await Product.create({
      productName,
      productDescription,
      price,
      availabilityStatus,
    });

    res.status(201).json(newProduct);
  } catch (error) {
    console.error('Error creating product:', error.message);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Update a specific product by ID
router.put('/products/:productId', async (req, res) => {
  const { productId } = req.params;
  const { productName, productDescription, price, availabilityStatus } = req.body;

  try {
    const updatedProduct = await Product.findByIdAndUpdate(
      productId,
      {
        productName,
        productDescription,
        price,
        availabilityStatus,
      },
      { new: true }
    );

    if (!updatedProduct) {
      return res.status(404).json({ error: 'Product not found' });
    }

    res.status(200).json(updatedProduct);
  } catch (error) {
    console.error('Error updating product:', error.message);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Delete a specific product by ID
router.delete('/products/:productId', async (req, res) => {
  const { productId } = req.params;

  try {
    const deletedProduct = await Product.findByIdAndDelete(productId);

    if (!deletedProduct) {
      return res.status(404).json({ error: 'Product not found' });
    }

    res.status(204).end();
  } catch (error) {
    console.error('Error deleting product:', error.message);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Endpoint to receive price updates from the Java service
router.post('/price-update', async (req, res) => {
  const { productId, price } = req.body;

  try {
    // Forward the price update request to the Java service
    await axios.post('http://localhost:8080/process-price-update', {
      productId,
      price
    });

    res.status(200).json({ message: 'Price update processed successfully' });
  } catch (error) {
    console.error('Error processing price update:', error.message);
    res.status(500).json({ error: 'Internal server error' });
  }
});

module.exports = router;
