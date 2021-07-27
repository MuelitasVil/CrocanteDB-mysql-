-- MySQL Script generated by MySQL Workbench
-- Sat May 29 11:41:01 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering



SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto` DEFAULT CHARACTER SET utf8 ;
USE `proyecto` ;

-- -----------------------------------------------------
-- Table `proyecto`.`Localidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Localidad` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Localidad` (
  `loc_id` INT(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `loc_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`loc_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Barrio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Barrio` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Barrio` (
  `bar_id` INT(10) UNSIGNED NOT NULL,
  `bar_nombre` VARCHAR(45) NOT NULL,
  `Localidad_loc_id` INT(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`bar_id`, `Localidad_loc_id`),
  INDEX `fk_Barrio_Localidad1_idx` (`Localidad_loc_id` ASC) VISIBLE,
  CONSTRAINT `fk_Barrio_Localidad1`
    FOREIGN KEY (`Localidad_loc_id`)
    REFERENCES `proyecto`.`Localidad` (`loc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Sede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Sede` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Sede` (
  `sede_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sede_nombre` VARCHAR(45) NOT NULL,
  `sede_dirección` VARCHAR(45) NOT NULL,
  `Barrio_bar_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`sede_id`),
  INDEX `fk_Sede_Barrio1_idx` (`Barrio_bar_id` ASC) VISIBLE,
  CONSTRAINT `fk_Sede_Barrio1`
    FOREIGN KEY (`Barrio_bar_id`)
    REFERENCES `proyecto`.`Barrio` (`bar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Persona` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Persona` (
  `per_id` BIGINT(10) UNSIGNED NOT NULL,
  `per_nombre` VARCHAR(45) NOT NULL DEFAULT 'Anónimo',
  `per_apellido` VARCHAR(45) NULL,
  `per_dirección` VARCHAR(45) NULL,
  `per_teléfono` BIGINT(10) UNSIGNED NULL,
  `per_correo` VARCHAR(45) NULL,
  PRIMARY KEY (`per_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Cargo` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Cargo` (
  `car_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `car_nombre` VARCHAR(45) NOT NULL,
  `car_descripción` TINYTEXT NULL,
  PRIMARY KEY (`car_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Empleado` (
  `emp_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `emp_horasSemanales` INT(2) UNSIGNED NOT NULL DEFAULT 0,
  `Sede_sede_id` INT(10) UNSIGNED NOT NULL,
  `Cargo_car_id` INT(10) UNSIGNED NOT NULL,
  `Persona_per_id` BIGINT(10) UNSIGNED NOT NULL,
  `emp_estado` Boolean NOT NULL,
  
  PRIMARY KEY (`emp_id`),
  INDEX `fk_Empleado_Sede1_idx` (`Sede_sede_id` ASC) VISIBLE,
  INDEX `fk_Empleado_Cargo1_idx` (`Cargo_car_id` ASC) VISIBLE,
  INDEX `fk_Empleado_Persona1_idx` (`Persona_per_id` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_Sede1`
    FOREIGN KEY (`Sede_sede_id`)
    REFERENCES `proyecto`.`Sede` (`sede_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Cargo1`
    FOREIGN KEY (`Cargo_car_id`)
    REFERENCES `proyecto`.`Cargo` (`car_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Persona1`
    FOREIGN KEY (`Persona_per_id`)
    REFERENCES `proyecto`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Insumo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Insumo` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Insumo` (
  `ins_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ins_nombre` VARCHAR(45) NOT NULL,
  `ins_existencia` TINYTEXT NOT NULL,
  PRIMARY KEY (`ins_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Gasto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Gasto` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Gasto` (
  `gast_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `gast_descripción` TINYTEXT NOT NULL,
  `gast_costo` INT(7) UNSIGNED NOT NULL,
  `gast_fecha` DATE NOT NULL,
  `gast_tipo` ENUM('Nomina', 'Servicios', 'Insumos', 'Otros') NOT NULL,
  `Sede_sede_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`gast_id`, `Sede_sede_id`),
  INDEX `fk_Gastos_Sede1_idx` (`Sede_sede_id` ASC) VISIBLE,
  CONSTRAINT `fk_Gastos_Sede1`
    FOREIGN KEY (`Sede_sede_id`)
    REFERENCES `proyecto`.`Sede` (`sede_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Proveedor` (
  `prov_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `prov_nombre` VARCHAR(45) NOT NULL DEFAULT 'Plaza',
  `prov_número` INT(10) UNSIGNED NULL,
  `prov_correo` VARCHAR(45) NULL,
  `prov_estado` Boolean NOT NULL,
  PRIMARY KEY (`prov_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`CompraAlProveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`CompraAlProveedor` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`CompraAlProveedor` (
  `Gastos_gast_id` INT(10) UNSIGNED NOT NULL,
  `Proveedor_prov_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Gastos_gast_id`, `Proveedor_prov_id`),
  INDEX `fk_CompraAlProveedor_Gastos1_idx` (`Gastos_gast_id` ASC) VISIBLE,
  INDEX `fk_CompraAlProveedor_Proveedor1_idx` (`Proveedor_prov_id` ASC) VISIBLE,
  CONSTRAINT `fk_CompraAlProveedor_Gastos1`
    FOREIGN KEY (`Gastos_gast_id`)
    REFERENCES `proyecto`.`Gasto` (`gast_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CompraAlProveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_prov_id`)
    REFERENCES `proyecto`.`Proveedor` (`prov_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Tipo` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Tipo` (
  `tip_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tip_tipo` VARCHAR(30) NOT NULL,
  `tip_estado` Boolean NOT NULL,
  PRIMARY KEY (`tip_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Producto` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Producto` (
  `pro_id` INT(2) UNSIGNED NOT NULL,
  `pro_nombre` VARCHAR(30) NOT NULL,
  `pro_precio` INT(5) UNSIGNED NOT NULL,
  `Tipo_tip_id` INT UNSIGNED NOT NULL,
  `pro_estado` Boolean NOT NULL,
  PRIMARY KEY (`pro_id`),
  INDEX `fk_Producto_Tipo1_idx` (`Tipo_tip_id` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Tipo1`
    FOREIGN KEY (`Tipo_tip_id`)
    REFERENCES `proyecto`.`Tipo` (`tip_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Venta` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Venta` (
  `ven_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ven_fecha` DATETIME NOT NULL,
  `ven_precioTotal` INT(6) UNSIGNED NOT NULL,
  `ven_formaPago` ENUM('Efectivo', 'Tarjeta', 'Online') NOT NULL,
  `ven_estadoPago` ENUM('Pagado', 'No Pago') NOT NULL,
  `ven_modalidad` ENUM('Domicilio', 'Presencial') NOT NULL,
  `ven_diaSemana` VARCHAR(45) NOT NULL,
  `Persona_per_id` BIGINT(10) UNSIGNED NOT NULL,
  `Sede_sede_id` INT(10) UNSIGNED NOT NULL,
  `ven_estado` Boolean NOT NULL,
  PRIMARY KEY (`ven_id`, `Persona_per_id`, `Sede_sede_id`),
  INDEX `fk_Venta_Persona1_idx` (`Persona_per_id` ASC) VISIBLE,
  INDEX `fk_Venta_Sede1_idx` (`Sede_sede_id` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Persona1`
    FOREIGN KEY (`Persona_per_id`)
    REFERENCES `proyecto`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Sede1`
    FOREIGN KEY (`Sede_sede_id`)
    REFERENCES `proyecto`.`Sede` (`sede_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Comentario` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Comentario` (
  `com_id` INT(10) UNSIGNED NOT NULL,
  `com_descripcion` TEXT NULL,
  `Persona_per_id` BIGINT(10) UNSIGNED NOT NULL,
  `Venta_ven_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`com_id`, `Persona_per_id`),
  INDEX `fk_Comentario_Persona1_idx` (`Persona_per_id` ASC) VISIBLE,
  INDEX `fk_Comentario_Venta1_idx` (`Venta_ven_id` ASC) VISIBLE,
  CONSTRAINT `fk_Comentario_Persona1`
    FOREIGN KEY (`Persona_per_id`)
    REFERENCES `proyecto`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Venta1`
    FOREIGN KEY (`Venta_ven_id`)
    REFERENCES `proyecto`.`Venta` (`ven_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Calificación`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Calificación` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Calificación` (
  `cal_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cal_estrellas` TINYINT(1) UNSIGNED NOT NULL,
  `cal_fecha` DATE NOT NULL,
  `Persona_per_id` BIGINT(10) UNSIGNED NOT NULL,
  `Comentario_com_id` INT(10) UNSIGNED NOT NULL,
  `Producto_pro_id` INT(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`cal_id`, `Persona_per_id`, `Producto_pro_id`),
  INDEX `fk_Calificación_Persona1_idx` (`Persona_per_id` ASC) VISIBLE,
  INDEX `fk_Calificación_Comentario1_idx` (`Comentario_com_id` ASC) VISIBLE,
  INDEX `fk_Calificación_Producto1_idx` (`Producto_pro_id` ASC) VISIBLE,
  CONSTRAINT `fk_Calificación_Persona1`
    FOREIGN KEY (`Persona_per_id`)
    REFERENCES `proyecto`.`Persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Calificación_Comentario1`
    FOREIGN KEY (`Comentario_com_id`)
    REFERENCES `proyecto`.`Comentario` (`com_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Calificación_Producto1`
    FOREIGN KEY (`Producto_pro_id`)
    REFERENCES `proyecto`.`Producto` (`pro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Domicilio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Domicilio` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Domicilio` (
  `dom_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dom_dirEntrega` VARCHAR(45) NOT NULL,
  `dom_tiempoEntrega` TIME NULL,
  `dom_estado` ENUM('No Enviado', 'En Camino', 'Entregado', 'Cancelado') NOT NULL,
  `dom_precio` INT(10) UNSIGNED NOT NULL default 2000,
  `Empleado_emp_id` INT(10) UNSIGNED NOT NULL,
  `Venta_ven_id` INT(10) UNSIGNED NOT NULL,
  `Barrio_bar_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`dom_id`),
  INDEX `fk_Domicilio_Empleado1_idx` (`Empleado_emp_id` ASC) VISIBLE,
  INDEX `fk_Domicilio_Venta1_idx` (`Venta_ven_id` ASC) VISIBLE,
  INDEX `fk_Domicilio_Barrio1_idx` (`Barrio_bar_id` ASC) VISIBLE,
  CONSTRAINT `fk_Domicilio_Empleado1`
    FOREIGN KEY (`Empleado_emp_id`)
    REFERENCES `proyecto`.`Empleado` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Domicilio_Venta1`
    FOREIGN KEY (`Venta_ven_id`)
    REFERENCES `proyecto`.`Venta` (`ven_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Domicilio_Barrio1`
    FOREIGN KEY (`Barrio_bar_id`)
    REFERENCES `proyecto`.`Barrio` (`bar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`InventarioProveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`InventarioProveedor` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`InventarioProveedor` (
  `Insumo_ins_id` INT(10) UNSIGNED NOT NULL,
  `Proveedor_prov_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Insumo_ins_id`, `Proveedor_prov_id`),
  INDEX `fk_InventarioProveedor_Insumo1_idx` (`Insumo_ins_id` ASC) VISIBLE,
  INDEX `fk_InventarioProveedor_Proveedor1_idx` (`Proveedor_prov_id` ASC) VISIBLE,
  CONSTRAINT `fk_InventarioProveedor_Insumo1`
    FOREIGN KEY (`Insumo_ins_id`)
    REFERENCES `proyecto`.`Insumo` (`ins_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_InventarioProveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_prov_id`)
    REFERENCES `proyecto`.`Proveedor` (`prov_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Salario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Salario` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Salario` (
  `Empleado_emp_id` INT(10) UNSIGNED NOT NULL,
  `sal_valor` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Empleado_emp_id`),
  INDEX `fk_Salario_Empleado1_idx` (`Empleado_emp_id` ASC) VISIBLE,
  CONSTRAINT `fk_Salario_Empleado1`
    FOREIGN KEY (`Empleado_emp_id`)
    REFERENCES `proyecto`.`Empleado` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`Pedido` (
  `Producto_pro_id` INT(2) UNSIGNED NOT NULL,
  `Venta_ven_id` INT(10) UNSIGNED NOT NULL,
  `Venta_Persona_per_id` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Producto_pro_id`, `Venta_ven_id`, `Venta_Persona_per_id`),
  INDEX `fk_Producto_has_Venta_Venta1_idx` (`Venta_ven_id` ASC, `Venta_Persona_per_id` ASC) VISIBLE,
  INDEX `fk_Producto_has_Venta_Producto1_idx` (`Producto_pro_id` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Venta_Producto1`
    FOREIGN KEY (`Producto_pro_id`)
    REFERENCES `proyecto`.`Producto` (`pro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Venta_Venta1`
    FOREIGN KEY (`Venta_ven_id` , `Venta_Persona_per_id`)
    REFERENCES `proyecto`.`Venta` (`ven_id` , `Persona_per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto`.`DetalleCompraInsumo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto`.`DetalleCompraInsumo` ;

CREATE TABLE IF NOT EXISTS `proyecto`.`DetalleCompraInsumo` (
  `Insumo_ins_id` INT(10) UNSIGNED NOT NULL,
  `CompraAlProveedor_Gastos_gast_id` INT(10) UNSIGNED NOT NULL,
  `CompraAlProveedor_Proveedor_prov_id` INT(10) UNSIGNED NOT NULL,
  `dci_cantidad` INT(3) UNSIGNED NOT NULL,
  `dci_precioUnitario` INT(6) UNSIGNED NOT NULL,
  PRIMARY KEY (`Insumo_ins_id`, `CompraAlProveedor_Gastos_gast_id`, `CompraAlProveedor_Proveedor_prov_id`),
  INDEX `fk_Insumo_has_CompraAlProveedor_CompraAlProveedor1_idx` (`CompraAlProveedor_Gastos_gast_id` ASC, `CompraAlProveedor_Proveedor_prov_id` ASC) VISIBLE,
  INDEX `fk_Insumo_has_CompraAlProveedor_Insumo1_idx` (`Insumo_ins_id` ASC) VISIBLE,
  CONSTRAINT `fk_Insumo_has_CompraAlProveedor_Insumo1`
    FOREIGN KEY (`Insumo_ins_id`)
    REFERENCES `proyecto`.`Insumo` (`ins_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Insumo_has_CompraAlProveedor_CompraAlProveedor1`
    FOREIGN KEY (`CompraAlProveedor_Gastos_gast_id` , `CompraAlProveedor_Proveedor_prov_id`)
    REFERENCES `proyecto`.`CompraAlProveedor` (`Gastos_gast_id` , `Proveedor_prov_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- select * from DetalleCompraInsumo;


