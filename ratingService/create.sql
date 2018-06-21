CREATE TABLE ratings (
    user_id bigint(20),
    reservation_id bigint(20),
    accommodation_id bigint(20) NOT NULL,
    rating int NOT NULL,
    PRIMARY KEY(user_id, reservation_id),
    CHECK (rating > 0 && rating < 6)
);