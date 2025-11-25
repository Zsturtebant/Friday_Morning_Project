/**
 * WizardTracker Class
 * -------------------
 * Tracks dark wizard activity using data from the Web API layer.
 * 
 * Responsibilities:
 * • Fetch nearby wizard data (real or fake) using Web.java
 * • Convert API offenders into magical TrackedWizard objects
 * • Store and manage a list of active dark wizard sightings
 * • Assign danger levels to each wizard
 * • Provide a display() method to show all tracked wizards
 * 
 * This class acts as the main “magical logic” engine for the
 * Wizard Watch application.
 */

import java.util.ArrayList;
import java.util.List;

public class WizardTracker {

    private Web web;  // Uses your Web class to fetch data

    // List of tracked dark wizards (in-app memory)
    private List<TrackedWizard> trackedWizards = new ArrayList<>();

    // Constructor
    public WizardTracker() {
        this.web = new Web();
    }

    // -----------------------------
    // Inner class: TrackedWizard
    // -----------------------------
    public static class TrackedWizard {
        String name;
        String dangerLevel;   // e.g. "High", "Severe", "Extreme"
        String profileUrl;

        public TrackedWizard(String name, String dangerLevel, String profileUrl) {
            this.name = name;
            this.dangerLevel = dangerLevel;
            this.profileUrl = profileUrl;
        }
    }

    // -----------------------------
    // Convert Offender -> TrackedWizard
    // -----------------------------
    private TrackedWizard convert(Web.Offender o) {

        String[] dangers = {"High", "Severe", "Extreme"};
        String danger = dangers[(o.name.length() + o.profileUrl.length()) % dangers.length];

        return new TrackedWizard(o.name, danger, o.profileUrl);
    }

    // -----------------------------
    // Search for Nearby Dark Wizards
    // -----------------------------
    public List<TrackedWizard> searchNearby(String name, String zipcode, String key) {
        try {
            Web.OffenderResponse response = web.search(name, zipcode, key);

            if (response == null || response.offenders == null) {
                return trackedWizards;
            }

            trackedWizards.clear(); // Refresh

            for (Web.Offender o : response.offenders) {
                trackedWizards.add(convert(o));
            }

            return trackedWizards;

        } catch (Exception e) {
            System.out.println("Spell failure: Could not contact the Ministry.");
            return trackedWizards;
        }
    }

    // -----------------------------
    // Fake / Random Magical Results
    // -----------------------------
    public List<TrackedWizard> fakeSearch() {

        Web.OffenderResponse response = web.fakeSearch();
        trackedWizards.clear();

        for (Web.Offender o : response.offenders) {
            trackedWizards.add(convert(o));
        }

        return trackedWizards;
    }

    // -----------------------------
    // Display Results
    // -----------------------------
    public void display() {
        if (trackedWizards.isEmpty()) {
            System.out.println("No dark wizard activity detected.");
            return;
        }

        for (TrackedWizard w : trackedWizards) {
            System.out.println("⚠️ Dark Wizard: " + w.name);
            System.out.println("Danger Level: " + w.dangerLevel);
            System.out.println("Ministry File: " + w.profileUrl);
            System.out.println("-----------------------------------");
        }
    }
}
