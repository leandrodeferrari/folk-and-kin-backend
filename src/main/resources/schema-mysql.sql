DROP SCHEMA IF EXISTS folk_and_kin;

CREATE SCHEMA IF NOT EXISTS folk_and_kin;

USE folk_and_kin;

CREATE TABLE IF NOT EXISTS roles(
	id TINYINT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(20) NOT NULL,
    CONSTRAINT PK_roles_id PRIMARY KEY(id),
    CONSTRAINT UQ_roles_nombre UNIQUE(nombre)
);

CREATE TABLE IF NOT EXISTS usuarios(
	id BIGINT AUTO_INCREMENT NOT NULL,
	nombre_de_usuario VARCHAR(50) NOT NULL,
	contrasenia VARCHAR(255) NOT NULL,
	email VARCHAR(50) NOT NULL,
	telefono VARCHAR(15),
	rol_id TINYINT NOT NULL,
    CONSTRAINT PK_usuarios_id PRIMARY KEY(id),
    CONSTRAINT FK_usuarios_rol_id FOREIGN KEY(rol_id) REFERENCES folk_and_kin.roles(id)
);

CREATE TABLE IF NOT EXISTS tiendas(
	id BIGINT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(20) NOT NULL,
    logo_url VARCHAR(255) NOT NULL,
	usuario_id BIGINT NOT NULL,
    CONSTRAINT PK_tiendas_id PRIMARY KEY(id),
    CONSTRAINT FK_tiendas_usuario_id FOREIGN KEY(usuario_id) REFERENCES folk_and_kin.usuarios(id)
);

CREATE TABLE IF NOT EXISTS productos(
	id BIGINT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	descripcion VARCHAR(1500) NOT NULL,
	precio DECIMAL(10,2) NOT NULL,
	stock INT,
    tienda_id BIGINT NOT NULL,
    CONSTRAINT PK_productos_id PRIMARY KEY(id),
	CONSTRAINT FK_productos_tienda_id FOREIGN KEY(tienda_id) REFERENCES folk_and_kin.tiendas(id)
);

CREATE TABLE IF NOT EXISTS fotos(
	id BIGINT AUTO_INCREMENT NOT NULL,
	url VARCHAR(255) NOT NULL,
    producto_id BIGINT NOT NULL,
    CONSTRAINT PK_fotos_id PRIMARY KEY(id),
    CONSTRAINT FK_fotos_producto_id FOREIGN KEY(producto_id) REFERENCES folk_and_kin.productos(id)
);

CREATE TABLE IF NOT EXISTS categorias(
	id INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(30) NOT NULL,
    CONSTRAINT PK_categorias_id PRIMARY KEY(id),
    CONSTRAINT UQ_categorias_nombre UNIQUE(nombre)
);

CREATE TABLE IF NOT EXISTS categorias_productos(
	id BIGINT AUTO_INCREMENT NOT NULL,
	producto_id BIGINT NOT NULL,
	categoria_id INT NOT NULL,
    CONSTRAINT PK_categorias_productos_id PRIMARY KEY(id),
	CONSTRAINT FK_categorias_productos_producto_id FOREIGN KEY(producto_id) REFERENCES folk_and_kin.productos(id),
    CONSTRAINT FK_categorias_productos_categoria_id FOREIGN KEY(categoria_id) REFERENCES folk_and_kin.categorias(id),
    CONSTRAINT UQ_categorias_productos_producto_id_categoria_id UNIQUE(producto_id, categoria_id)
);

CREATE TABLE IF NOT EXISTS colores(
	id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    codigo_hexadecimal VARCHAR(7) NOT NULL,
    CONSTRAINT PK_colores_id PRIMARY KEY(id),
	CONSTRAINT UQ_colores_nombre UNIQUE(nombre),
    CONSTRAINT UQ_colores_codigo_hexadecimal UNIQUE(codigo_hexadecimal)
);

CREATE TABLE IF NOT EXISTS colores_productos(
	id BIGINT AUTO_INCREMENT NOT NULL,
    stock INT NOT NULL,
	producto_id BIGINT NOT NULL,
	color_id INT NOT NULL,
    CONSTRAINT PK_colores_productos_id PRIMARY KEY(id),
    CONSTRAINT FK_colores_productos_producto_id FOREIGN KEY(producto_id) REFERENCES folk_and_kin.productos(id),
	CONSTRAINT FK_colores_productos_color_id FOREIGN KEY(color_id) REFERENCES folk_and_kin.colores(id),
    CONSTRAINT UQ_colores_productos_producto_id_color_id UNIQUE(producto_id, color_id)
);

CREATE TABLE IF NOT EXISTS estandares_de_talles(
	id INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(20) NOT NULL,
    CONSTRAINT PK_estandares_de_talles_id PRIMARY KEY(id),
    CONSTRAINT UQ_estandares_de_talles_nombre UNIQUE(nombre)
);

CREATE TABLE IF NOT EXISTS talles(
	id INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(20) NOT NULL,
    estandar_id INT NOT NULL,
    CONSTRAINT PK_talles_id PRIMARY KEY(id),
	CONSTRAINT FK_talles_estandar_id FOREIGN KEY(estandar_id) REFERENCES folk_and_kin.estandares_de_talles(id),
    CONSTRAINT UQ_talles_nombre UNIQUE(nombre)
);

CREATE TABLE IF NOT EXISTS talles_productos(
	id BIGINT AUTO_INCREMENT NOT NULL,
    stock INT NOT NULL,
	producto_id BIGINT NOT NULL,
	talle_id INT NOT NULL,
    CONSTRAINT PK_talles_productos_id PRIMARY KEY(id),
    CONSTRAINT FK_talles_productos_producto_id FOREIGN KEY(producto_id) REFERENCES folk_and_kin.productos(id),
	CONSTRAINT FK_talles_productos_talle_id FOREIGN KEY(talle_id) REFERENCES folk_and_kin.talles(id),
    CONSTRAINT UQ_talles_productos_producto_id_talle_id UNIQUE(producto_id, talle_id)
);