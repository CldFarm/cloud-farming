--liquibase formatted sql

--changeset sean:vanwyk:plotdata:1 label:mock context:@mock
INSERT INTO plot_data (plotid, growth_percent, sunlight, soil_moisture, time_taken) VALUES
  (1, 0, 40, 80, '2024-03-13'),
  (2, 0, 10, 30, '2023-10-01'),
  (2, 10, 13, 23, '2023-10-02'),
  (2, 25, 17, 42, '2023-10-03'),
  (2, 50, 40, 10, '2023-10-04'),
  (2, 100, 3, 78, '2023-10-05');
--rollback DROP FROM plot_data;