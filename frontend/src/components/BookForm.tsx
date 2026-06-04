import { useState } from "react";

export function BookForm({
  onAdd,
}: {
  onAdd: (title: string, author: string) => void;
}) {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");

  return (
    <div className="flex gap-2 mb-4">
      <input
        className="border p-2 w-full"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />

      <input
        className="border p-2 w-full"
        placeholder="Author"
        value={author}
        onChange={(e) => setAuthor(e.target.value)}
      />

      <button
        className="bg-green-600 text-white px-4 rounded"
        onClick={() => {
          if (!title || !author) return;
          onAdd(title, author);
          setTitle("");
          setAuthor("");
        }}
      >
        Add
      </button>
    </div>
  );
}