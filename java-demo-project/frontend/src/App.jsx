import { useEffect, useState } from 'react';

const API_URL = '/api/v1/posts';

function App() {
  const [posts, setPosts] = useState([]);
  const [form, setForm] = useState({ title: '', content: '', author: '', category: '' });
  const [loading, setLoading] = useState(true);

  const fetchPosts = async () => {
    const response = await fetch(API_URL);
    const data = await response.json();
    setPosts(data);
    setLoading(false);
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
    await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(form)
    });
    setForm({ title: '', content: '', author: '', category: '' });
    fetchPosts();
  };

  const removePost = async (id) => {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    fetchPosts();
  };

  return (
    <div className="page">
      <header className="hero">
        <div>
          <p className="eyebrow">Spring Boot + React + MongoDB</p>
          <h1>Welcome to the team blog</h1>
          <p>Share ideas, updates, and progress with a simple, modern posting experience.</p>
        </div>
      </header>

      <main className="layout">
        <section className="panel form-panel">
          <h2>Create a new post</h2>
          <form onSubmit={handleSubmit}>
            <input value={form.title} onChange={(e) => setForm({ ...form, title: e.target.value })} placeholder="Post title" required />
            <textarea value={form.content} onChange={(e) => setForm({ ...form, content: e.target.value })} placeholder="Write something inspiring..." rows="5" required />
            <input value={form.author} onChange={(e) => setForm({ ...form, author: e.target.value })} placeholder="Author" required />
            <input value={form.category} onChange={(e) => setForm({ ...form, category: e.target.value })} placeholder="Category" required />
            <button type="submit">Publish post</button>
          </form>
        </section>

        <section className="panel list-panel">
          <h2>Latest posts</h2>
          {loading ? <p>Loading posts...</p> : posts.length === 0 ? <p>No posts yet. Be the first to write one.</p> : (
            <div className="post-list">
              {posts.map((post) => (
                <article key={post.id} className="post-card">
                  <div className="post-top">
                    <span className="chip">{post.category}</span>
                    <button onClick={() => removePost(post.id)} className="delete-btn">Delete</button>
                  </div>
                  <h3>{post.title}</h3>
                  <p>{post.content}</p>
                  <div className="post-footer">
                    <span>By {post.author}</span>
                  </div>
                </article>
              ))}
            </div>
          )}
        </section>
      </main>
    </div>
  );
}

export default App;
