package com.example.demo.resources;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/recipe")
public class RecipeResource {
    RecipeService recipeService = new RecipeService();
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe getRecipeById(@PathParam("id") int id) {
        return recipeService.fetchOneRecipe(id);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> searchRecipeByKeyword(@QueryParam("keyword") String keyword) {
        if (keyword.equals("Breakfast") || keyword.equals("Diner") || keyword.equals("Lunch") ||
        keyword.equals("breakfast") || keyword.equals("diner") || keyword.equals("lunch")) {
            return Recipe.randomRecipe(recipeService.fetchRecipeByKeyWord(keyword));
        }
        return recipeService.fetchRecipeByKeyWord(keyword);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> getAllRecipes() {
        return recipeService.fetchAllRecipes();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response createRecipe(Recipe recipe) {
        Recipe recipeCreated = recipeService.createRecipe(recipe);
        return Response
                .status(Response.Status.CREATED).entity(recipeCreated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRecipe(@PathParam("id") int id) {
        recipeService.deleteRecipe(Math.toIntExact(id));
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateRecipe(@PathParam("id") int id, Recipe recipe) {
        recipeService.updateRecipe((id), recipe);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}