const mongoose = require('mongoose');

const productSchema = new mongoose.Schema({
  productName: String,
  productDescription: String,
  price: Number,
  availabilityStatus: Boolean,
});

const Product = mongoose.model('Product', productSchema);

module.exports = Product;
