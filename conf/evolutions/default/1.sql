# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table address (
  id                        bigint not null,
  address_details           varchar(255),
  person_id                 varchar(255),
  constraint pk_address primary key (id))
;

create table person (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;

create sequence address_seq;

create sequence person_seq;

alter table address add constraint fk_address_person_1 foreign key (person_id) references person (id) on delete restrict on update restrict;
create index ix_address_person_1 on address (person_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists address;

drop table if exists person;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists address_seq;

drop sequence if exists person_seq;

