CREATE TABLE ratings (
    user_id bigint(20),
    reservation_id bigint(20),
    rating int NOT NULL,
    PRIMARY KEY(user_id, reservation_id),
    CHECK (rating > 0 && rating < 6)
);