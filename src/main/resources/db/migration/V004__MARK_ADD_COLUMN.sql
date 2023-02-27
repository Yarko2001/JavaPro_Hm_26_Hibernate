ALTER TABLE my_university.mark ADD COLUMN fk_student_id integer default null;
ALTER TABLE my_university.mark ADD foreign key (fk_student_id) references my_university.student (id);

ALTER TABLE my_university.mark ALTER COLUMN status SET NOT NULL;
ALTER TABLE my_university.mark ALTER COLUMN discipline SET NOT NULL;

ALTER TABLE my_university.student ALTER COLUMN name SET NOT NULL;
ALTER TABLE my_university.student ALTER COLUMN email SET NOT NULL;