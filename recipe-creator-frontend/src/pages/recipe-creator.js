import { useState } from "react";
import axios from "axios";

export default function RecipeCreator() {
  const [ingredients, setIngredients] = useState("");
  const [cuisine, setCuisine] = useState("any");
  const [dietaryRestrictions, setDietaryRestrictions] = useState("");
  const [recipe, setRecipe] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    setRecipe(null);
  
    try {
      // Ensure ingredients are properly formatted
      const formattedIngredients = ingredients.split(",").map((item) => item.trim()).join(",");
  
      const response = await axios.get("http://localhost:8080/recipe-creator", {
        params: {
          ingredients: formattedIngredients,
          cuisine,
          dietaryRestrictions,
        },
      });
      setRecipe(response.data);
    } catch (err) {
      setError("Failed to fetch the recipe. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h1>Recipe Creator</h1>
      <form onSubmit={handleSubmit} style={{ marginBottom: "20px" }}>
        <div style={{ marginBottom: "10px" }}>
          <label>
            Ingredients (comma-separated):
            <br />
            <input
              type="text"
              value={ingredients}
              onChange={(e) => setIngredients(e.target.value)}
              placeholder="e.g., chicken, rice, carrots"
              style={{ width: "100%", padding: "8px", marginTop: "5px" }}
              required
            />
          </label>
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label>
            Cuisine Type:
            <br />
            <input
              type="text"
              value={cuisine}
              onChange={(e) => setCuisine(e.target.value)}
              placeholder="e.g., Italian, Chinese"
              style={{ width: "100%", padding: "8px", marginTop: "5px" }}
            />
          </label>
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label>
            Dietary Restrictions:
            <br />
            <input
              type="text"
              value={dietaryRestrictions}
              onChange={(e) => setDietaryRestrictions(e.target.value)}
              placeholder="e.g., gluten-free, vegan"
              style={{ width: "100%", padding: "8px", marginTop: "5px" }}
            />
          </label>
        </div>
        <button
          type="submit"
          style={{
            padding: "10px 20px",
            backgroundColor: "#0070f3",
            color: "white",
            border: "none",
            borderRadius: "5px",
            cursor: "pointer",
          }}
        >
          {loading ? "Generating..." : "Create Recipe"}
        </button>
      </form>

      {error && <p style={{ color: "red" }}>{error}</p>}

      {recipe && (
        <div>
          <h2>Generated Recipe</h2>
          <pre
            style={{
              backgroundColor: "#f4f4f4",
              padding: "10px",
              borderRadius: "5px",
              whiteSpace: "pre-wrap",
            }}
          >
            {recipe}
          </pre>
        </div>
      )}
    </div>
  );
}