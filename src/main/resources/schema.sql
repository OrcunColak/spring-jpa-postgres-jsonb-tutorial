
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    data JSONB,
    json_list JSONB,
    json_map JSONB
);