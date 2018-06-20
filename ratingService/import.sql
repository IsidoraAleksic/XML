CREATE TABLE ratings (
    user_id bigint(20),
    accommodation_unit_id bigint(20),
    rating int NOT NULL,
    PRIMARY KEY(user_id, accommodation_unit_id),
    CHECK (rating > 0 && rating < 6)
);