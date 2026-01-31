mysql> desc reservations;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| id         | int         | NO   | PRI | NULL    |       |
| guest_name | varchar(50) | YES  |     | NULL    |       |
| check_in   | timestamp   | YES  |     | NULL    |       |
| room_no    | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
# Hotel-reservation
Hotel reservation system using java
