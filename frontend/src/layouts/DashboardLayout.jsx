import { Link, useNavigate } from "react-router-dom";

function DashboardLayout({ children }) {

    const navigate = useNavigate();

    const handleLogout = () => {

        localStorage.removeItem("token");

        navigate("/");
    };

    return (

        <div className="flex min-h-screen bg-gray-100">

            {/* Sidebar */}

            <div className="w-64 bg-blue-700 text-white p-5">

                <h1 className="text-3xl font-bold mb-10">

                    Hostel ERP

                </h1>

                <nav className="space-y-4">

                    <Link
                        to="/dashboard"
                        className="block hover:bg-blue-600 p-3 rounded-lg"
                    >

                        Dashboard

                    </Link>

                    <Link
                        to="/hostels"
                        className="block hover:bg-blue-600 p-3 rounded-lg"
                    >

                        Hostels

                    </Link>

                    <Link
                        to="/rooms"
                        className="block hover:bg-blue-600 p-3 rounded-lg"
                    >

                        Rooms

                    </Link>

                    <Link
                        to="/students"
                        className="block hover:bg-blue-600 p-3 rounded-lg"
                    >

                        Students

                    </Link>

                    <Link
                        to="/fees"
                        className="block hover:bg-blue-600 p-3 rounded-lg"
                    >

                        Fees

                    </Link>

                </nav>

            </div>

            {/* Main Content */}

            <div className="flex-1">

                {/* Navbar */}

                <div className="bg-white shadow p-5 flex justify-between items-center">

                    <h2 className="text-2xl font-bold">

                        Admin Dashboard

                    </h2>

                    <button

                        onClick={handleLogout}

                        className="bg-red-500 text-white px-4 py-2 rounded-lg hover:bg-red-600"
                    >

                        Logout

                    </button>

                </div>

                {/* Page Content */}

                <div className="p-8">

                    {children}

                </div>

            </div>

        </div>
    )
}

export default DashboardLayout