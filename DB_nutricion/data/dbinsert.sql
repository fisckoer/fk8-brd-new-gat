INSERT INTO menu_week (id, start_date)
VALUES (1, '2024-03-01');

INSERT INTO menu_day (id, day_of_week, menu_week_id) VALUES
(1,'MONDAY',1),
(2,'TUESDAY',1),
(3,'WEDNESDAY',1),
(4,'THURSDAY',1),
(5,'FRIDAY',1),
(6,'SATURDAY',1),
(7,'SUNDAY',1);

INSERT INTO ingredient (id,name) VALUES
(1,'Pan integral'),
(2,'Jamón de pavo'),
(3,'Espinaca'),
(4,'Germinado'),
(5,'Brócoli'),
(6,'Tortilla harina integral'),
(7,'Aguacate'),
(8,'Lechuga'),
(9,'Champiñones'),
(10,'Crema'),
(11,'Huevo'),
(12,'Yogurt griego'),
(13,'Piña'),
(14,'Papaya'),
(15,'All Bran'),
(16,'Chía'),
(17,'Linaza'),
(18,'Carne de res'),
(19,'Chayote'),
(20,'Zanahoria'),
(21,'Calabacita'),
(22,'Chile ancho'),
(23,'Chile guajillo'),
(24,'Jitomate'),
(25,'Cebolla'),
(26,'Ajo'),
(27,'Epazote'),
(28,'Queso panela'),
(29,'Frijoles'),
(30,'Pechuga de pollo'),
(31,'Carne hamburguesa'),
(32,'Papa'),
(33,'Atún'),
(34,'Nopal'),
(35,'Fresas'),
(36,'Chocolate 70%'),
(37,'Almendras'),
(38,'Nueces'),
(39,'Cacahuates'),
(40,'Aceite de oliva');

INSERT INTO recipe (id,name,notes,preparation,calories,favorite) VALUES
(1,'Sandwich en sandwichera','Acompañar con té o café descremado',
 'Colocar el jamón y espinaca entre las rebanadas de pan integral y tostar en sandwichera 3-5 minutos.',320,false),

(2,'Wraps de jamón','Acompañar con té de manzanilla',
 'Colocar ingredientes en tortilla integral, enrollar firmemente y servir fresco.',380,false),

(3,'Enchiladas verdes','Puede usarse crema ligera',
 'Rellenar tortillas con champiñones, cubrir con salsa verde y hornear 10 minutos.',450,false),

(4,'Tostadas rancheras','Huevos a la mexicana',
 'Preparar huevos revueltos con jitomate y cebolla y servir sobre tostadas.',420,false),

(5,'Smoothie digestivo','Colación matutina',
 'Licuar todos los ingredientes hasta obtener consistencia homogénea.',280,false),

(6,'Mole de olla','Plato fuerte tradicional',
 'Cocer carne con verduras y chiles durante 40 minutos hasta suavizar.',520,false),

(7,'Espagueti de calabaza con queso','Con panela rallada',
 'Saltear calabaza en tiras con aceite y mezclar con queso panela.',480,false),

(8,'Pechuga asada con ensalada de frijol','Alta proteína',
 'Asar pechuga y mezclar frijoles con verduras frescas.',510,false),

(9,'Hamburguesa con lechuga','Con papa horneada',
 'Formar carne, asar 5 minutos por lado y servir envuelta en lechuga.',650,false),

(10,'Lasaña de nopal','Con salsa roja',
 'Intercalar nopales asados con queso y frijoles y hornear 15 minutos.',430,false),

(11,'Pepino relleno de atún','Cena ligera',
 'Mezclar atún con verduras y rellenar medio pepino.',300,false),

(12,'Fresas con chocolate','Colación dulce',
 'Derretir chocolate y mezclar con fresas rebanadas.',250,false),

(13,'Ensalada libre con proteína','Cena personalizable',
 'Mezclar proteína elegida con verduras frescas y frutos secos.',500,false);

 INSERT INTO recipe_recipe_type VALUES
(1,'DESAYUNO'),
(2,'DESAYUNO'),
(3,'COMIDA'),
(4,'DESAYUNO'),
(5,'COLACION'),
(6,'COMIDA'),
(7,'COMIDA'),
(8,'COMIDA'),
(9,'COMIDA'),
(10,'CENA'),
(11,'CENA'),
(12,'COLACION'),
(13,'CENA');

INSERT INTO recipe_ingredient VALUES
(1,1,'2 rebanadas'),
(1,2,'2 rebanadas'),
(1,3,'4 hojas'),

(2,6,'2 piezas'),
(2,7,'1/3 pieza'),
(2,2,'2 rebanadas'),

(3,6,'2 piezas'),
(3,9,'1/2 taza'),
(3,10,'2 cucharadas'),

(4,11,'2 piezas'),
(4,7,'1/3 pieza'),

(5,12,'3 cucharadas'),
(5,13,'1 rebanada'),
(5,14,'1 rebanada'),
(5,15,'1/2 taza'),

(6,18,'120g'),
(6,19,'1/2 pieza'),
(6,20,'1/2 pieza'),
(6,21,'1 pieza'),

(7,21,'1 pieza'),
(7,28,'120g'),

(8,30,'100g'),
(8,29,'1/2 taza'),

(9,31,'150g'),
(9,32,'1/2 pieza'),

(10,34,'3 piezas'),
(10,28,'3 rebanadas'),

(11,33,'1 lata'),

(12,35,'1/2 taza'),
(12,36,'18g'),

(13,30,'150g'),
(13,8,'libre');


INSERT INTO meal (type,time,menu_day_id,recipe_id) VALUES
('DESAYUNO','09:30',1,1),
('COLACION','11:30',1,5),
('COMIDA','14:30',1,6),
('COLACION','17:30',1,12),
('CENA','20:30',1,13);
