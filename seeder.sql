create DATABASE if not exists vivetlist_db;
use vivetlist_db;

INSERT INTO notification_type(name) VALUES ('TEXT'), ('EMAIL'), ('BOTH');

insert into appointments(date_time, doctor_name, location, user_id)
    VALUES('2018-05-21 15:00:00', 'Hawkeye', 'Mobile Clinic', 1),
      ('2018-06-01 09:30:00', 'Howser', 'Memorial', 2),
      ('2018-05-18 11:45:00', 'Welby', 'Baptist', 3),
      ('2018-12-17 14:00:00', 'Grey', 'Medical Dr', 4),
      ('2018-08-13 16:15:00', 'Shepherd', 'Mercy Clinic', 5),
      ('2018-10-01 15:15:00', 'Hunnicutt', 'Military Dr', 6);

insert into groups(name, description)
    values('Diabetes','Diabetes is a number of diseases that involve problems with the hormone insulin. This group is intended to help those suffering with diabetes to communicate and help each other.'),
    ('Cancer', 'Cancer is when abnormal cells divide in an uncontrolled way. Users can use this group to discuss treatment options and outreach to help patients and their families.'),
    ('PTSD', 'This group is for those suffering from Post Traumatic Stress Disorder (PTSD), a psychiatric disorder that can occur in people who have experienced or witnessed a traumatic event.'),
    ('Multiple Sclerosis', 'MS remains a mystery, but there''s also a wealth of information available. This group will help those with MS to communicate and help each other with new treatments and their results.'),
    ('Congenital Heart Disease', 'With congenital heart defects, some part of the heart doesn''t form properly before birth. This group is for adults with CHD or parents of children with CHD.'),
    ('ADHD', 'This group is for those with Attention Deficit Hyperactivity Disorder (ADHD), a highly genetic, brain-based syndrome that has to do with the regulation of a particular set of brain functions and related behaviors.');

insert into medicines(medicine_name, refill_date, user_id)
    VALUES ('insulin', '2018-06-02 10:00:00', 1),
      ('insulin', '2018-08-01 12:00:00', 2),
      ('codeine', '2018-07-10 09:00:00', 3),
      ('avonex', '2018-05-25 15:00:00', 4),
      ('atenolol', '2018-06-30 10:00:00', 5),
      ('adderall', '2018-11-18 17:00:00', 6);

insert into posts(title, body, group_id, user_id)
    values('Diabetic for 5 years', 'Hi, I was diagnosed 5 years ago. It''s nice to be able to connect with others who have the disease.', 1, 1),
      ('Glucose Meter', 'Has anyone had trouble with their glucose meter malfunctioning?', 1, 2),
      ('Meetup Group', 'Hi, I would like to start an in-person support group for PTSD. Is anyone interested?', 3, 3),
      ('Diet?', 'Can anyone give me diet advice to help manage my symptoms?', 4, 4),
      ('Statistics', 'I had no idea that ADHD is harder to diagnose in women!', 6, 5);

insert into comments(body, post_id, user_id)
    VALUES ('What kind of glucose meter do you have?', 2, 6),
      ('I would love to join an in-person support group!!', 3, 2),
      ('Wow, I didn''t know that either!!', 5, 4);




