import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";

import LoginPage from "./pages/LoginPage";

import DashboardPage from "./pages/DashboardPage";

import HostelsPage from "./pages/HostelsPage";

import AddHostelPage from "./pages/AddHostelPage";

import ProtectedRoute from "./routes/ProtectedRoute";

function App() {

  return (

    <BrowserRouter>

      <Routes>

        {/* Login */}

        <Route
          path="/"
          element={<LoginPage />}
        />

        {/* Dashboard */}

        <Route

          path="/dashboard"

          element={

            <ProtectedRoute>

              <DashboardPage />

            </ProtectedRoute>
          }
        />

        {/* IMPORTANT:
            Add route BEFORE /hostels
        */}

        <Route

          path="/hostels/add"

          element={

            <ProtectedRoute>

              <AddHostelPage />

            </ProtectedRoute>
          }
        />

        {/* Hostels */}

        <Route

          path="/hostels"

          element={

            <ProtectedRoute>

              <HostelsPage />

            </ProtectedRoute>
          }
        />

      </Routes>

    </BrowserRouter>
  )
}

export default App;