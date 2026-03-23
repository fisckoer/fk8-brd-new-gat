CREATE OR REPLACE FUNCTION nutri.get_recipe_ingredient(p_recipe_id bigint)
 RETURNS TABLE(i_id BIGINT, i_name VARCHAR, quantity VARCHAR, is_optional BOOLEAN, option_group INTEGER )
 LANGUAGE plpgsql
AS $function$

 BEGIN
 return query
  SELECT i.id, i.name, ri.quantity, ri.is_optional, ri.option_group
  from recipe_ingredient ri
JOIN ingredient i on i.id = ri.ingredient_id where ri.recipe_id = p_recipe_id;
END;
$function$
