import DashboardLayout from "../layouts/DashboardLayout";

function DashboardPage() {

    return (

        <DashboardLayout>

            <div>

                <h1 className="text-4xl font-bold mb-8">

                    Dashboard Overview

                </h1>

                <div className="grid grid-cols-3 gap-6">

                    <div className="bg-white p-6 rounded-2xl shadow">

                        <h2 className="text-gray-500">

                            Total Students

                        </h2>

                        <p className="text-4xl font-bold mt-2">

                            120
                        </p>

                    </div>

                    <div className="bg-white p-6 rounded-2xl shadow">

                        <h2 className="text-gray-500">

                            Total Rooms

                        </h2>

                        <p className="text-4xl font-bold mt-2">

                            60
                        </p>

                    </div>

                    <div className="bg-white p-6 rounded-2xl shadow">

                        <h2 className="text-gray-500">

                            Occupied Rooms

                        </h2>

                        <p className="text-4xl font-bold mt-2">

                            45
                        </p>

                    </div>

                </div>

            </div>

        </DashboardLayout>
    )
}

export default DashboardPage