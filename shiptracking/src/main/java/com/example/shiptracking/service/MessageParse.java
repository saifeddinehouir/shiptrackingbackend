package com.example.shiptracking.service;

import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public class MessageParse {

    public static void parseMessage(String jsonString) {
        try {
            // Parse the JSON string
            JSONObject jsonObject = new JSONObject(jsonString);

            // Check if the MessageType is "PositionReport"
            String messageType = jsonObject.getString("MessageType");
            if ("PositionReport".equals(messageType)) {
                // Extract the MetaData object
                JSONObject metaData = jsonObject.getJSONObject("MetaData");

                // Extract individual fields from the MetaData object
                int mmsi = metaData.getInt("MMSI");
                String mmsiString = String.valueOf(metaData.getInt("MMSI_String"));
                String shipName = metaData.getString("ShipName").trim();
                double latitude = metaData.getDouble("latitude");
                double longitude = metaData.getDouble("longitude");
                String timeUtc = metaData.getString("time_utc");

                // Print the extracted data
                System.out.println("MMSI: " + mmsi);
                System.out.println("MMSI String: " + mmsiString);
                System.out.println("Ship Name: " + shipName);
                System.out.println("Latitude: " + latitude);
                System.out.println("Longitude: " + longitude);
                System.out.println("Time UTC: " + timeUtc);

                // Store data in the database
                DataInsertion.storeVesselData(mmsi, mmsiString, shipName, latitude, longitude, timeUtc);
            } else {
                System.out.println("Message type is not PositionReport.");
            }
        } catch (JSONException e) {
            // Handle JSON exception
            System.err.println("Error parsing JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
