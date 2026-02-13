CREATE TABLE menu_week (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_date DATE NOT NULL
);

CREATE TABLE menu_day (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    day_of_week ENUM(
        'MONDAY','TUESDAY','WEDNESDAY',
        'THURSDAY','FRIDAY','SATURDAY','SUNDAY'
    ) NOT NULL,
    menu_week_id BIGINT NOT NULL,
    FOREIGN KEY (menu_week_id)
        REFERENCES menu_week(id)
        ON DELETE CASCADE
);

CREATE TABLE recipe (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    notes TEXT,
    calories INT,
    favorite BOOLEAN DEFAULT FALSE
);

CREATE TABLE ingredient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE recipe_ingredient (
    recipe_id BIGINT NOT NULL,
    ingredient_id BIGINT NOT NULL,
    quantity VARCHAR(100) NOT NULL,

    PRIMARY KEY (recipe_id, ingredient_id),

    FOREIGN KEY (recipe_id)
        REFERENCES recipe(id)
        ON DELETE CASCADE,

    FOREIGN KEY (ingredient_id)
        REFERENCES ingredient(id)
        ON DELETE CASCADE
);

CREATE TABLE meal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type ENUM('DESAYUNO','COMIDA','COLACION','CENA') NOT NULL,
    time TIME NOT NULL,
    menu_day_id BIGINT NOT NULL,
    recipe_id BIGINT NOT NULL,

    FOREIGN KEY (menu_day_id)
        REFERENCES menu_day(id)
        ON DELETE CASCADE,

    FOREIGN KEY (recipe_id)
        REFERENCES recipe(id)
        ON DELETE CASCADE
);
