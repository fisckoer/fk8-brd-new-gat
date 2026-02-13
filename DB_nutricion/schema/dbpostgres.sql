DROP SCHEMA IF EXISTS nutri CASCADE;
CREATE SCHEMA nutri;
SET search_path TO nutri


-- =========================================
-- EXTENSIONES (opcional si usarás UUID en futuro)
-- =========================================
-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =========================================
-- ENUMS
-- =========================================

CREATE TYPE meal_type_enum AS ENUM (
    'DESAYUNO',
    'COMIDA',
    'COLACION',
    'CENA'
);

CREATE TYPE day_of_week_enum AS ENUM (
    'MONDAY',
    'TUESDAY',
    'WEDNESDAY',
    'THURSDAY',
    'FRIDAY',
    'SATURDAY',
    'SUNDAY'
);

CREATE TYPE recipe_type_enum AS ENUM (
    'DESAYUNO',
    'COMIDA',
    'COLACION',
    'CENA'
);

-- =========================================
-- TABLE: menu_week
-- =========================================

CREATE TABLE menu_week (
    id BIGSERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================
-- TABLE: menu_day
-- =========================================

CREATE TABLE menu_day (
    id BIGSERIAL PRIMARY KEY,
    day_of_week day_of_week_enum NOT NULL,
    menu_week_id BIGINT NOT NULL,

    CONSTRAINT fk_menu_week
        FOREIGN KEY (menu_week_id)
        REFERENCES menu_week(id)
        ON DELETE CASCADE
);

-- =========================================
-- TABLE: recipe
-- =========================================

CREATE TABLE recipe (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    notes TEXT,
    preparation TEXT,
    calories INTEGER,
    favorite BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================
-- TABLE: ingredient
-- =========================================

CREATE TABLE ingredient (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- =========================================
-- TABLE: recipe_ingredient (N:M)
-- =========================================

CREATE TABLE recipe_ingredient (
    recipe_id BIGINT NOT NULL,
    ingredient_id BIGINT NOT NULL,
    quantity VARCHAR(100) NOT NULL,

    PRIMARY KEY (recipe_id, ingredient_id),

    CONSTRAINT fk_recipe
        FOREIGN KEY (recipe_id)
        REFERENCES recipe(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_ingredient
        FOREIGN KEY (ingredient_id)
        REFERENCES ingredient(id)
        ON DELETE CASCADE
);

-- =========================================
-- TABLE: recipe_recipe_type (N:M)
-- =========================================

CREATE TABLE recipe_recipe_type (
    recipe_id BIGINT NOT NULL,
    recipe_type recipe_type_enum NOT NULL,

    PRIMARY KEY (recipe_id, recipe_type),

    CONSTRAINT fk_recipe_type_recipe
        FOREIGN KEY (recipe_id)
        REFERENCES recipe(id)
        ON DELETE CASCADE
);

-- =========================================
-- TABLE: meal
-- =========================================

CREATE TABLE meal (
    id BIGSERIAL PRIMARY KEY,
    type meal_type_enum NOT NULL,
    time TIME NOT NULL,
    menu_day_id BIGINT NOT NULL,
    recipe_id BIGINT NOT NULL,

    CONSTRAINT fk_menu_day
        FOREIGN KEY (menu_day_id)
        REFERENCES menu_day(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_meal_recipe
        FOREIGN KEY (recipe_id)
        REFERENCES recipe(id)
        ON DELETE CASCADE
);

-- =========================================
-- INDEXES (performance)
-- =========================================

CREATE INDEX idx_menu_day_week ON menu_day(menu_week_id);
CREATE INDEX idx_meal_day ON meal(menu_day_id);
CREATE INDEX idx_meal_recipe ON meal(recipe_id);
CREATE INDEX idx_recipe_ingredient_recipe ON recipe_ingredient(recipe_id);
CREATE INDEX idx_recipe_ingredient_ingredient ON recipe_ingredient(ingredient_id);
CREATE INDEX idx_recipe_type_recipe ON recipe_recipe_type(recipe_id);

-- =========================================
-- OPTIONAL: Vista útil para menú diario
-- =========================================

CREATE VIEW daily_menu_view AS
SELECT
    mw.id AS week_id,
    md.day_of_week,
    m.type AS meal_type,
    m.time,
    r.id AS recipe_id,
    r.name AS recipe_name,
    r.calories
FROM meal m
JOIN menu_day md ON m.menu_day_id = md.id
JOIN menu_week mw ON md.menu_week_id = mw.id
JOIN recipe r ON m.recipe_id = r.id;
