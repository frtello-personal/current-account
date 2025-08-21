CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS conceptos(
    id uuid PRIMARY KEY,
    tipo text NOT NULL,
    nombre text NOT NULL,
    fecha_actualizacion timestamptz NOT NULL DEFAULT now(),
    usuario_actualizacion text NOT NULL
);
CREATE INDEX conceptos_tipo_index ON conceptos (tipo);
INSERT INTO conceptos (id, tipo, nombre, fecha_actualizacion, usuario_actualizacion) VALUES
(uuid_generate_v4(), 'DEBITO', 'IMPUESTO', now(), 'currentAccount'),
(uuid_generate_v4(), 'DEBITO', 'INTERES', now(), 'currentAccount'),
(uuid_generate_v4(), 'DEBITO', 'MULTA', now(), 'currentAccount'),
(uuid_generate_v4(), 'DEBITO', 'MORA', now(), 'currentAccount'),
(uuid_generate_v4(), 'CREDITO', 'PAGO', now(), 'currentAccount'),
(uuid_generate_v4(), 'CREDITO', 'CREDITO FISCAL', now(), 'currentAccount'),
(uuid_generate_v4(), 'CREDITO', 'EXONERACION', now(), 'currentAccount'),
(uuid_generate_v4(), 'CREDITO', 'BENEFICIO', now(), 'currentAccount');


CREATE TABLE IF NOT EXISTS cuentas(
    id uuid PRIMARY KEY,
    id_cliente uuid NOT NULL,
    impuesto integer NOT NULL,
    fecha_actualizacion timestamptz NOT NULL DEFAULT now(),
    usuario_actualizacion text NOT NULL
);
CREATE INDEX cuentas_cliente_index ON cuentas (id_cliente);
CREATE INDEX cuentas_impuesto_index ON cuentas (impuesto);

CREATE TABLE IF NOT EXISTS debitos(
    id uuid PRIMARY KEY,
    id_cuenta uuid NOT NULL,
    id_concepto uuid NOT NULL,
    periodo integer NOT NULL,
    valor decimal NOT NULL,
    id_documento uuid NOT NULL,
    fecha_transaccion timestamptz NOT NULL,
    fecha_registro timestamptz NOT NULL DEFAULT now(),
    usuario_actualizacion text NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES cuentas(id),
    FOREIGN KEY (id_concepto) REFERENCES conceptos(id)
);
CREATE INDEX debitos_periodo_index ON debitos (periodo);
CREATE INDEX debitos_id_documento_index ON debitos (id_documento);

CREATE TABLE IF NOT EXISTS creditos(
    id uuid PRIMARY KEY,
    id_cuenta uuid NOT NULL,
    id_concepto uuid NOT NULL,
    periodo integer NOT NULL,
    valor decimal NOT NULL,
    id_documento uuid NOT NULL,
    fecha_transaccion timestamptz NOT NULL,
    fecha_registro timestamptz NOT NULL DEFAULT now(),
    usuario_actualizacion text NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES cuentas(id),
    FOREIGN KEY (id_concepto) REFERENCES conceptos(id)
);
CREATE INDEX creditos_periodo_index ON creditos (periodo);
CREATE INDEX creditos_id_documento_index ON creditos (id_documento);