DROP TABLE IF EXISTS orders;

CREATE TABLE tracking_status (
  tracking_status_id IDENTITY PRIMARY KEY,
  tracking_status_id_name VARCHAR(250) NOT NULL
);

CREATE TABLE orders (
  order_id IDENTITY AUTO_INCREMENT  PRIMARY KEY,
  tracking_status_id LONG NOT NULL,
  change_status_date TIMESTAMP WITH TIME ZONE DEFAULT NULL,
  foreign key (tracking_status_id) references tracking_status(tracking_status_id) 
);

INSERT INTO tracking_status (tracking_status_id, tracking_status_id_name) VALUES
  (1, 'RECOGIDO EN ALMACEN'),
  (2, 'EN REPARTO'),
  (3, 'INCIDENCIA EN ENTREGA'),
  (4, 'ENTREGADO');
  
  INSERT INTO orders (tracking_status_id, change_status_date) VALUES
  (1, '2019-01-27T07:18:23.108+00:00');