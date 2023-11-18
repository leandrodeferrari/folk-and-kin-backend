USE folk_and_kin;

-- ROLES

INSERT INTO roles(nombre) VALUES('ADMINISTRADOR');

-- USUARIOS

INSERT INTO usuarios(nombre_de_usuario, contrasenia, email, telefono, rol_id) 
	VALUES('leandro_deferrari', '$2a$10$HN.2kCJ/Wj/rjhttVvFAPOOfqV44YbzQEloNgMW5cJnQju3lQpSTO', 'leandro@folkandkin.com', null, 1);
INSERT INTO usuarios(nombre_de_usuario, contrasenia, email, telefono, rol_id) 
	VALUES('juan_centurion', '$2a$10$HN.2kCJ/Wj/rjhttVvFAPOOfqV44YbzQEloNgMW5cJnQju3lQpSTO', 'juan@folkandkin.com', '1522003344', 1);
INSERT INTO usuarios(nombre_de_usuario, contrasenia, email, telefono, rol_id) 
	VALUES('diego_hidalgo', '$2a$10$HN.2kCJ/Wj/rjhttVvFAPOOfqV44YbzQEloNgMW5cJnQju3lQpSTO', 'diego@folkandkin.com', '1533001122', 1);

-- TIENDAS

INSERT INTO tiendas(nombre, logo_url, usuario_id) VALUES('Joyas Mario', 'https://www.joyasmario.com/logo', 1);
INSERT INTO tiendas(nombre, logo_url, usuario_id) VALUES('Celucash', 'https://www.celucash.com/logo', 2);
INSERT INTO tiendas(nombre, logo_url, usuario_id) VALUES('Mueblería Osvaldo', 'https://www.muebleriaosvaldo.com/logo', 3);

-- PRODUCTOS

INSERT INTO productos(nombre, descripcion, precio, stock, tienda_id)  
	VALUES('Anillo de plata Snox', 'Anillo bañado en plata, con un diamante', 75000, null, 1);
INSERT INTO productos(nombre, descripcion, precio, stock, tienda_id)  
	VALUES('Pulsera Infinito', 'Pulsera bañada en oro, con cristales incrustados tanto en el dije del infinito, como en la pulsera.', 14400, null, 1);
INSERT INTO productos(nombre, descripcion, precio, stock, tienda_id) 
	VALUES('Samsung Galaxy A50', 'Celular gama media.', 89000, null, 2);
INSERT INTO productos(nombre, descripcion, precio, stock, tienda_id)  
	VALUES('Samsung Galaxy S22', 'Celular gama alta.', 459999, null, 2);
INSERT INTO productos(nombre, descripcion, precio, stock, tienda_id)  
	VALUES('Silla en madera de Pino', 'Silla realizada con Pino macizo, modelo nube.', 12000, 50, 3);
INSERT INTO productos(nombre, descripcion, precio, stock, tienda_id)  
	VALUES('Mesa en madera de Pino', 'Mesa realizada con Pino macizo, modelo nube.', 20000, 100, 3);

-- FOTOS

INSERT INTO fotos(url, producto_id) 
	VALUES('www.joyasmario.com/images/1', 1);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.joyasmario.com/images/2', 2);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.celucash.com/images/1', 3);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.celucash.com/images/3', 3);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.celucash.com/images/4', 3);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.celucash.com/images/2', 4);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.muebleriaosvaldo.com/images/1', 5);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.muebleriaosvaldo.com/images/2', 6);
INSERT INTO fotos(url, producto_id) 
	VALUES('www.muebleriaosvaldo.com/images/3', 6);

-- CATEGORIAS

INSERT INTO categorias(nombre) VALUES('Mueblería');
INSERT INTO categorias(nombre) VALUES('Joyería');
INSERT INTO categorias(nombre) VALUES('Anillos');
INSERT INTO categorias(nombre) VALUES('Celulares');

-- CATEGORIAS_PRODUCTOS

INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(1, 2);
INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(1, 3);
INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(2, 2);
INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(3, 4);
INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(4, 4);
INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(5, 1);
INSERT INTO categorias_productos(producto_id, categoria_id) VALUES(6, 1);

-- COLORES

INSERT INTO colores(nombre, codigo_hexadecimal) VALUES('Blanco', '#FFFFFF');
INSERT INTO colores(nombre, codigo_hexadecimal) VALUES('Negro', '#000000');
INSERT INTO colores(nombre, codigo_hexadecimal) VALUES('Verde', '#00FF00');
INSERT INTO colores(nombre, codigo_hexadecimal) VALUES('Azul', '#0000FF');
INSERT INTO colores(nombre, codigo_hexadecimal) VALUES('Rojo', '#FF0000');
INSERT INTO colores(nombre, codigo_hexadecimal) VALUES('Plata', '#C0C0C0');

-- COLORES_PRODUCTOS

INSERT INTO colores_productos(stock, producto_id, color_id) 
	VALUES(500, 3, 1);
INSERT INTO colores_productos(stock, producto_id, color_id) 
	VALUES(500, 3, 2);
INSERT INTO colores_productos(stock, producto_id, color_id) 
	VALUES(300, 4, 3);
INSERT INTO colores_productos(stock, producto_id, color_id) 
	VALUES(100, 4, 2);
INSERT INTO colores_productos(stock, producto_id, color_id) 
	VALUES(200, 4, 6);

-- ESTANDARES DE TALLES

INSERT INTO estandares_de_talles(nombre) VALUES('Adultos');
INSERT INTO estandares_de_talles(nombre) VALUES('Niños');
INSERT INTO estandares_de_talles(nombre) VALUES('Calzados');
INSERT INTO estandares_de_talles(nombre) VALUES('Personalizados');

-- TALLES

INSERT INTO talles(nombre, estandar_id) VALUES('XS', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('S', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('M', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('L', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('XL', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('XXL', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('XXXL', 1);
INSERT INTO talles(nombre, estandar_id) VALUES('2', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('4', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('6', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('8', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('10', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('12', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('14', 2);
INSERT INTO talles(nombre, estandar_id) VALUES('34', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('35', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('36', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('37', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('38', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('39', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('40', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('41', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('42', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('43', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('44', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('45', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('46', 3);
INSERT INTO talles(nombre, estandar_id) VALUES('N°1', 4);
INSERT INTO talles(nombre, estandar_id) VALUES('N°2', 4);
INSERT INTO talles(nombre, estandar_id) VALUES('N°3', 4);

-- TALLES_PRODUCTOS

INSERT INTO talles_productos(stock, producto_id, talle_id) VALUES(30, 1, 2);
INSERT INTO talles_productos(stock, producto_id, talle_id) VALUES(50, 1, 3);
INSERT INTO talles_productos(stock, producto_id, talle_id) VALUES(20, 1, 4);
INSERT INTO talles_productos(stock, producto_id, talle_id) VALUES(70, 2, 2);
INSERT INTO talles_productos(stock, producto_id, talle_id) VALUES(100, 2, 3);
INSERT INTO talles_productos(stock, producto_id, talle_id) VALUES(80, 2, 4);