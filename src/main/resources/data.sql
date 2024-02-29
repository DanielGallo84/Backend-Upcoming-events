INSERT INTO events(id_event,title,date,hour,place,description,capacity,is_outstanding,img) VALUES (DEFAULT,"Concierto","01/01/2025","22:00","Madrid","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,true,"event2.jpg");
INSERT INTO events(id_event,title,date,hour,place,description,capacity,is_outstanding,img) VALUES (DEFAULT,"Concierto","01/02/2025","23:00","Madrid","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,true,"event3.jpg");
INSERT INTO events(id_event,title,date,hour,place,description,capacity,is_outstanding,img) VALUES (DEFAULT,"Concierto","01/03/2025","21:00","Madrid","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,false,"event6.jpg");
INSERT INTO events(id_event,title,date,hour,place,description,capacity,is_outstanding,img) VALUES (DEFAULT,"Concierto","01/04/2025","22:00","Madrid","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,false,"event7.png");
INSERT INTO events(id_event,title,date,hour,place,description,capacity,is_outstanding,img) VALUES (DEFAULT,"Concierto","01/05/2025","19:00","Madrid","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempor vulputate dui, id bibendum lectus venenatis quis. Aliquam ac ligula porttitor, scelerisque nisi ac, sollicitudin augue.",100,false,"event8.jpeg");

INSERT INTO roles(id_role,name) VALUES (DEFAULT,"ROLE_ADMIN");
INSERT INTO roles(id_role,name) VALUES (DEFAULT,"ROLE_USER");

INSERT INTO users(id_user,username,password) VALUES (DEFAULT,"admin","$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO");
INSERT INTO users(id_user,username,password) VALUES (DEFAULT,"user","$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO");

INSERT INTO roles_users(role_id,user_id) VALUES (1,1);
INSERT INTO roles_users(role_id,user_id) VALUES (2,2);
