DELETE FROM Category;
INSERT INTO Category (id, category_name) VALUES
					   (1, 'Fruit'),
					   (2, 'Vegtable'),
					   (3, 'Drink'),
					   (4, 'Food'),
					   (5, 'Hygiene'),
					   (6, 'Other');

DELETE FROM Product;
INSERT INTO Product (id, name, price, quantity, unit_of_measurement, category_id) VALUES
					 (1, 'Apple', 0.99, 200, 'KG', 1),
					 (2, 'Bannana', 1.20, 324, 'KG', 1),
					 (3, 'Milk', 0.80, 180, 'L', 3),
					 (4, 'Carrot', 1.40, 200, 'KG', 2),
					 (5, 'Soap', 1.50, 85, 'PCS', 5),
					 (6, 'Chocolate', 1, 200, 'PCS', 4),
					 (7, 'Water', 0.20, 1500, 'PCS', 3),
					 (8, 'Coca Cola', 0.70, 1000, 'PCS', 1),
					 (9, 'Chewing Gum', 0.50, 450, 'PCS', 6),
					 (10, 'Kitchen paper', 2.40, 200, 'PCS', 6);
					 
DELETE FROM Sale;
INSERT INTO Sale (id, sold_date, units_sold, product_id) VALUES
				  (1, '20200813', 2, 1),
				  (2, '20200813', 3, 2),
				  (3, '20200813', 10, 3),
				  (4, '20200813', 1, 6),
				  (5, '20200813', 20, 7),
				  (6, '20200813', 3, 6),
				  (7, '20200813', 3, 8),
				  (8, '20200813', 7, 10),
				  (9, '20200813', 2, 4),
				  (10, '20200813', 10, 9),
				  (11, '20200813', 10, 7),
				  (12, '20200813', 6, 10),
				  (13, '20200814', 5, 2),
				  (14, '20200814', 3, 1),
				  (15, '20200814', 4, 9),
				  (16, '20200814', 2, 8),
				  (17, '20200814', 3, 4),
				  (18, '20200814', 5, 3),
				  (19, '20200814', 3, 2),
  				  (20, '20200814', 1, 1);