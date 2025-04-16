import Link from "next/link";

export default function Home() {
  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h1>Welcome to the Recipe Creator</h1>
      <p>
        Use our AI-powered recipe creator to generate recipes based on your
        ingredients, cuisine preferences, and dietary restrictions.
      </p>
      <Link href="/recipe-creator"
          style={{
            padding: "10px 20px",
            backgroundColor: "#0070f3",
            color: "white",
            border: "none",
            borderRadius: "5px",
            textDecoration: "none",
          }}
        >
          Go to Recipe Creator
      </Link>
    </div>
  );
}