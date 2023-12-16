const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const axios = require('axios');
const productRoutes = require('./routes/productRoutes'); 

const app = express();
const PORT = 3000;

app.use(bodyParser.json());

// MongoDB connection setup (replace with your MongoDB connection string)
mongoose.connect('mongodb://localhost:27017/digital-products', { useNewUrlParser: true, useUnifiedTopology: true });

// Use product routes
app.use(productRoutes);

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
