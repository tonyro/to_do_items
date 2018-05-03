-- Drop table

-- DROP TABLE public.to_do_item

CREATE TABLE public.to_do_item (
	to_do_id serial NOT NULL,
	description varchar(100) NOT NULL,
	notes varchar(256) NULL,
	created_dt timestamp NULL DEFAULT now(),
	updated_dt timestamp NULL DEFAULT now(),
	alarm_dt timestamp NULL,
	is_done bool NULL,
	CONSTRAINT to_do_item_pkey PRIMARY KEY (to_do_id)
)
WITH (
	OIDS=FALSE
) ;


-- Drop table

-- DROP TABLE public.to_do_comment

CREATE TABLE public.to_do_comment (
	comment_id serial NOT NULL,
	to_do_id int4 NULL,
	comment_text varchar(256) NULL,
	created_dt timestamp NULL DEFAULT now(),
	updated_dt timestamp NULL DEFAULT now(),
	CONSTRAINT to_do_comment_pkey PRIMARY KEY (comment_id),
	CONSTRAINT to_do_comment_to_do_id_fkey FOREIGN KEY (to_do_id) REFERENCES to_do_item(to_do_id)
)
WITH (
	OIDS=FALSE
) ;