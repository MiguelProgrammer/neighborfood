PGDMP      5                |            food    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16396    food    DATABASE        CREATE DATABASE food WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE food;
                postgres    false            �            1259    16409    cliente_entity_seq    SEQUENCE     |   CREATE SEQUENCE public.cliente_entity_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.cliente_entity_seq;
       public          postgres    false            �            1259    16410    pedido_entity_seq    SEQUENCE     {   CREATE SEQUENCE public.pedido_entity_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.pedido_entity_seq;
       public          postgres    false            �           0    0    cliente_entity_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.cliente_entity_seq', 1, false);
          public          postgres    false    215            �           0    0    pedido_entity_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.pedido_entity_seq', 1, false);
          public          postgres    false    216           