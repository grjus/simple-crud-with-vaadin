CREATE TABLE IF NOT EXISTS post (
    uuid UUID PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    text TEXT,
    created_at DATE
);
