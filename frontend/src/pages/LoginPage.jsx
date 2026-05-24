import { useState } from "react";

import { useNavigate } from "react-router-dom";

import api from "../services/api";

function LoginPage() {

  const navigate = useNavigate();

  const [email, setEmail] = useState("");

  const [password, setPassword] = useState("");

  const [loading, setLoading] = useState(false);

  const handleLogin = async (e) => {

  e.preventDefault();

  try {

    setLoading(true);

    const response = await api.post(

      "/auth/login",

      {

        email,

        password,
      }
    );

    console.log(response.data);

    if (response.data.success) {

      const token =
        response.data.data.token;

      localStorage.setItem(
        "token",
        token
      );

      alert("Login successful");

      navigate("/dashboard");

    } else {

      alert("Invalid credentials");
    }

  } catch (error) {

    console.error(error);

    alert("Login failed");

  } finally {

    setLoading(false);
  }
};

  return (

    <div className="min-h-screen flex items-center justify-center bg-gray-100">

      <div className="bg-white p-10 rounded-2xl shadow-lg w-[400px]">

        <h1 className="text-3xl font-bold text-center mb-6">

          Admin Login

        </h1>

        <form
          onSubmit={handleLogin}
          className="space-y-4"
        >

          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) =>
              setEmail(e.target.value)
            }
            className="w-full border p-3 rounded-lg"
          />

          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) =>
              setPassword(e.target.value)
            }
            className="w-full border p-3 rounded-lg"
          />

          <button
            type="submit"
            disabled={loading}
            className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700"
          >

            {

              loading

                ?

                "Logging in..."

                :

                "Login"
            }

          </button>

        </form>

      </div>

    </div>
  )
}

export default LoginPage