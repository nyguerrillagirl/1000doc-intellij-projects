-- Breads
INSERT INTO products (category, image_url, name, text, price_per_item)
VALUES
    ('breads', '/images/bread_item.jpg', 'Country Sourdough Loaf', "Special", 4.50),
    ('breads', '/images/bread_item.jpg', 'Honey Wheat Bread', NULL, 3.75),
    ('breads', '/images/bread_item.jpg', 'Italian Ciabatta', "Popular!", 4.25),
    ('breads', '/images/bread_item.jpg', 'French Baguette', NULL, 2.95),
    ('breads', '/images/bread_item.jpg', 'Multigrain Seeded Loaf', NULL, 5.25),
    ('breads', '/images/bread_item.jpg', 'Rosemary Focaccia', NULL, 4.95);

-- Pastries
INSERT INTO products (category, image_url, name, text, price_per_item)
VALUES
   ('pastries', '/images/pastry_item.jpg', 'Butter Croissant', NULL, 2.75),
   ('pastries', '/images/pastry_item.jpg', 'Chocolate Croissant', NULL, 3.25),
   ('pastries', '/images/pastry_item.jpg', 'Cinnamon Roll', NULL, 3.50),
   ('pastries', '/images/pastry_item.jpg', 'Almond Danish', NULL, 3.95),
   ('pastries', '/images/pastry_item.jpg', 'Apple Turnover', NULL, 3.45),
   ('pastries', '/images/pastry_item.jpg', 'Raspberry Cream Cheese Pastry', NULL, 3.85);

-- Pies
INSERT INTO products (category, image_url, name, text, price_per_item)
VALUES
   ('pies', '/images/pie_item.jpg', 'Classic Apple Pie', NULL, 12.00),
   ('pies', '/images/pie_item.jpg', 'Blueberry Pie', NULL, 13.00),
   ('pies', '/images/pie_item.jpg', 'Cherry Lattice Pie', NULL, 14.00),
   ('pies', '/images/pie_item.jpg', 'Pecan Pie', NULL, 15.00),
   ('pies', '/images/pie_item.jpg', 'Pumpkin Pie', NULL, 11.00),
   ('pies', '/images/pie_item.jpg', 'Key Lime Pie', NULL, 13.50);

-- Cakes
INSERT INTO products (category, image_url, name, text, price_per_item)
VALUES
   ('cakes', '/images/cake_item.jpg', 'Vanilla Buttercream Cake', NULL, 18.00),
   ('cakes', '/images/cake_item.jpg', 'Chocolate Fudge Cake', NULL, 19.00),
   ('cakes', '/images/cake_item.jpg', 'Red Velvet Cake', NULL, 20.00),
   ('cakes', '/images/cake_item.jpg', 'Lemon Raspberry Cake', NULL, 21.00),
   ('cakes', '/images/cake_item.jpg', 'Carrot Walnut Cake', NULL, 17.50),
   ('cakes', '/images/cake_item.jpg', 'Strawberry Shortcake', NULL, 18.50);
