import { useEffect, useState } from "react";

import DashboardLayout from "../layouts/DashboardLayout";

import api from "../services/api";

function HostelsPage() {

    const [hostels, setHostels] =
        useState([]);

    const [loading, setLoading] =
        useState(true);

    const fetchHostels = async () => {

        try {

            const response =
                await api.get("/hostels");

            setHostels(response.data.data);

        } catch (error) {

            console.error(error);

            alert("Failed to fetch hostels");

        } finally {

            setLoading(false);
        }
    };

    useEffect(() => {

        fetchHostels();

    }, []);

    return (

        <DashboardLayout>

            <div>

                <div className="flex justify-between items-center mb-8">

                    <h1 className="text-4xl font-bold">

                        Hostels

                    </h1>

                    <button

                        onClick={() =>
                            window.location.href =
                            "/hostels/add"
                        }

                        className="bg-blue-600 text-white px-5 py-3 rounded-xl hover:bg-blue-700"
                    >

                        Add Hostel

                    </button>

                </div>

                {

                    loading

                        ?

                        (

                            <p className="text-lg">

                                Loading...

                            </p>
                        )

                        :

                        hostels.length === 0

                            ?

                            (

                                <div className="bg-white p-10 rounded-2xl shadow text-center">

                                    <h2 className="text-2xl font-bold mb-4">

                                        No Hostels Found

                                    </h2>

                                    <p className="text-gray-600">

                                        Add your first hostel building
                                        to begin managing rooms and
                                        students.

                                    </p>

                                </div>
                            )

                            :

                            (

                                <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-6">

                                    {

                                        hostels.map((hostel) => (

                                            <div

                                                key={hostel.id}

                                                className="bg-white p-6 rounded-2xl shadow hover:shadow-lg transition"
                                            >

                                                <div className="flex justify-between items-start">

                                                    <h2 className="text-2xl font-bold">

                                                        {hostel.hostelName}

                                                    </h2>

                                                    <span className="bg-blue-100 text-blue-700 px-3 py-1 rounded-full text-sm font-semibold">

                                                        {hostel.hostelType}

                                                    </span>

                                                </div>

                                                <div className="mt-5 space-y-3">

                                                    <p className="text-gray-600">

                                                        <span className="font-semibold">

                                                            Total Floors:
                                                        </span>

                                                        {" "}

                                                        {hostel.totalFloors}

                                                    </p>

                                                    <p className="text-gray-600">

                                                        <span className="font-semibold">

                                                            Description:
                                                        </span>

                                                        {" "}

                                                        {

                                                            hostel.description

                                                                ?

                                                                hostel.description

                                                                :

                                                                "No description"
                                                        }

                                                    </p>

                                                </div>

                                            </div>
                                        ))
                                    }

                                </div>
                            )
                }

            </div>

        </DashboardLayout>
    )
}

export default HostelsPage;