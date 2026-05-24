import { useState } from "react";

import { useNavigate } from "react-router-dom";

import DashboardLayout from "../layouts/DashboardLayout";

import api from "../services/api";

function AddHostelPage() {

    const navigate = useNavigate();

    const [hostelName, setHostelName] =
        useState("");

    const [hostelType, setHostelType] =
        useState("BOYS");

    const [totalFloors, setTotalFloors] =
        useState("");

    const [description, setDescription] =
        useState("");

    const [loading, setLoading] =
        useState(false);

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            setLoading(true);

            await api.post(

                "/hostels",

                {
                    hostelName,
                    hostelType,
                    totalFloors:
                        Number(totalFloors),
                    description,
                }
            );

            alert(
                "Hostel added successfully"
            );

            navigate("/hostels");

        } catch (error) {

            console.error(error);

            alert("Failed to add hostel");

        } finally {

            setLoading(false);
        }
    };

    return (

        <DashboardLayout>

            <div className="max-w-2xl">

                <h1 className="text-4xl font-bold mb-8">

                    Add Hostel Building

                </h1>

                <form

                    onSubmit={handleSubmit}

                    className="bg-white p-8 rounded-2xl shadow space-y-6"
                >

                    <div>

                        <label className="block mb-2 font-semibold">

                            Hostel Name

                        </label>

                        <input

                            type="text"

                            value={hostelName}

                            onChange={(e) =>
                                setHostelName(
                                    e.target.value
                                )
                            }

                            className="w-full border p-3 rounded-lg"

                            required
                        />

                    </div>

                    <div>

                        <label className="block mb-2 font-semibold">

                            Hostel Type

                        </label>

                        <select

                            value={hostelType}

                            onChange={(e) =>
                                setHostelType(
                                    e.target.value
                                )
                            }

                            className="w-full border p-3 rounded-lg"
                        >

                            <option value="BOYS">

                                Boys

                            </option>

                            <option value="GIRLS">

                                Girls

                            </option>

                        </select>

                    </div>

                    <div>

                        <label className="block mb-2 font-semibold">

                            Total Floors

                        </label>

                        <input

                            type="number"

                            value={totalFloors}

                            onChange={(e) =>
                                setTotalFloors(
                                    e.target.value
                                )
                            }

                            className="w-full border p-3 rounded-lg"

                            required
                        />

                    </div>

                    <div>

                        <label className="block mb-2 font-semibold">

                            Description

                        </label>

                        <textarea

                            value={description}

                            onChange={(e) =>
                                setDescription(
                                    e.target.value
                                )
                            }

                            className="w-full border p-3 rounded-lg"

                            rows={4}
                        />

                    </div>

                    <button

                        type="submit"

                        disabled={loading}

                        className="bg-blue-600 text-white px-6 py-3 rounded-xl hover:bg-blue-700"
                    >

                        {

                            loading

                                ?

                                "Saving..."

                                :

                                "Add Hostel"
                        }

                    </button>

                </form>

            </div>

        </DashboardLayout>
    )
}

export default AddHostelPage;