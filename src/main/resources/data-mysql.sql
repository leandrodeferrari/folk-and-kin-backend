USE folk_and_kin;

-- ROLES

INSERT INTO roles(nombre) VALUES('ADMIN');

-- USUARIOS

INSERT INTO usuarios(nombre_de_usuario, contrasenia, email, telefono, rol_id)
	VALUES('leandro_deferrari', '$2a$10$HN.2kCJ/Wj/rjhttVvFAPOOfqV44YbzQEloNgMW5cJnQju3lQpSTO', 'leandro@folkandkin.com', null, 1);
INSERT INTO usuarios(nombre_de_usuario, contrasenia, email, telefono, rol_id)
	VALUES('juan_centurion', '$2a$10$HN.2kCJ/Wj/rjhttVvFAPOOfqV44YbzQEloNgMW5cJnQju3lQpSTO', 'juan@folkandkin.com', '1522003344', 1);
INSERT INTO usuarios(nombre_de_usuario, contrasenia, email, telefono, rol_id)
	VALUES('diego_hidalgo', '$2a$10$HN.2kCJ/Wj/rjhttVvFAPOOfqV44YbzQEloNgMW5cJnQju3lQpSTO', 'diego@folkandkin.com', '1533001122', 1);

-- TIENDAS

INSERT INTO tiendas(nombre, logo_url, usuario_id) VALUES('Joyas Mario', 'https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449322/samples/folk-and-kin/Default_Awesome_logo_for_a_custom_ecommerce_service_website_No_1_601af824-0f78-4884-838c-9391e273e68d_0_kxpqfc.png', 1);
INSERT INTO tiendas(nombre, logo_url, usuario_id) VALUES('Celucash', 'https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449199/samples/folk-and-kin/Default_Awesome_logo_for_a_custom_ecommerce_service_website_No_2_ce7a42f3-7099-469b-87ac-6da6dbe964f4_0_fflgrx.png', 2);
INSERT INTO tiendas(nombre, logo_url, usuario_id) VALUES('Mueblería Osvaldo', 'https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449274/samples/folk-and-kin/Leonardo_Diffusion_Awesome_logo_for_a_custom_ecommerce_service_0_szggjb.jpg', 3);

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
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449446/samples/folk-and-kin/11-03474-030BIG1_nlezfm.webp', 1);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449523/samples/folk-and-kin/D_NQ_NP_2X_712431-MLA70542357555_072023-F_ygv6wv.webp', 2);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449646/samples/folk-and-kin/41LgdYnCy1L._AC_SR38_50__vtg16k.jpg', 3);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449642/samples/folk-and-kin/21DPho-SwcL._AC_SR38_50__hical9.jpg', 3);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449643/samples/folk-and-kin/21ptfJojGLL._AC_SR38_50__izxukm.jpg', 3);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449794/samples/folk-and-kin/D_NQ_NP_2X_664777-MLA54360533898_032023-F_za9dy2.webp', 4);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449853/samples/folk-and-kin/D_NQ_NP_2X_911934-MLA51279898172_082022-F_nykjoa.webp', 5);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449938/samples/folk-and-kin/D_NQ_NP_2X_826225-MLA48245659830_112021-F_qoktu8.webp', 6);
INSERT INTO fotos(url, producto_id)
	VALUES('https://res.cloudinary.com/dy7gwan0n/image/upload/v1700449941/samples/folk-and-kin/D_NQ_NP_2X_975662-MLA25534647700_042017-F_htt9v1.webp', 6);

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