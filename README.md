Wizard Watch
What It Does

Wizard Watch is an enchanted app designed to keep magical citizens safe and informed about dark wizard activity nearby. Using real-time GPS data and verified records from the Ministry of Magic, the app notifies users whenever a dark wizard is detected in their area. It functions much like a Muggle offender tracker but with advanced magical algorithms and enchanted GPS spells.

Key features include:

Dark Wizard Tracker: Monitors the last-known locations of dangerous wizards.

Interactive Map: Displays nearby dark wizard sightings.

Alert System: Sends notifications when a dark wizard is close.

Wizard Profiles: Lists offenses, known spells, and danger ratings.

Ministry Integration: Updates daily from verified Ministry data.

Team Members

Dillon Mensah – Developer / Backend Logic – GitHub: @dillonmensah

Aisha Aloma – Designer / UI-UX – GitHub: @aishaaloma

Hamilton Hamm – Data Engineer / Integration Lead – GitHub: @hamiltonhamm

Egwuatu Oneal – Data Analyst / Algorithm Specialist – GitHub: @onealegwuatu

Zackary Sturtevant – Project Manager / Frontend Developer – GitHub: @zacksturtevant

Setup Instructions

How to run Wizard Watch locally:

Clone the repository:

git clone https://github.com/<your-repo-link>.git


Navigate to the project directory:

cd wizard-watch


Install dependencies:

pip install -r requirements.txt


Launch the app:

python app.py


Open your browser and go to http://localhost:5000

Technologies Used

Language: Python

Frameworks: Flask (for web), Leaflet.js (for interactive maps)

Libraries: Pandas, Requests, Geopy

Tools: GitHub, Google Maps API, Figma

Project Structure
wizard-watch/
│
├── app.py               # Main application logic
├── static/              # CSS, JavaScript, and image assets
├── templates/           # HTML templates for UI
├── data/                # Verified dark wizard datasets
├── models/              # Backend models and tracking algorithms
├── requirements.txt     # Dependencies
└── README.md            # Project overview

How to Contribute

Fork the repository.

Create a new branch (git checkout -b feature-name).

Commit your changes (git commit -m "Add new feature").

Push to your branch (git push origin feature-name).

Open a Pull Request for review.

Current Status

✅ Core features implemented: GPS tracking, alert system, basic profiles

⚙️ In progress: Ministry API integration, user authentication, premium dashboard

🚀 Upcoming: Subscription model, sponsored magical business partnerships

Problem Statement

Have you ever wondered who’s lurking in the shadows of the wizarding world? Dark wizards pose a serious threat to magical communities, yet few tools exist to identify or track them. Wizard Watch solves this by making information about dark wizard activity accessible and actionable for every witch and wizard.

How It Makes Money

Wizard Watch operates under a freemium model:

Free tier: Basic alerts and location data.

Premium subscription: Detailed wizard profiles, crime histories, and exclusive Ministry reports.

Additional revenue streams:

Aggregated data licensing for research and security analysis

Sponsored ads and partnerships with magical businesses (wand makers, spell shops)

License

Choose a license at choosealicense.com

Would you like me to turn this into a ready-to-upload README.md file for GitHub (formatted with markdown styling and spacing)?
What is actually gonna be done in this project?
We are going to use a java class to pull the location of registered sex offenders and display a list within a certain radius of the user. 
Work Tasks
Take the user location and store it - wizard_tracker.java
Pull loaction of registered sex offenders - web.java
Sort the list of the sex offenders based off distance from user - main.java
Display the list up to a certain distance based off user input - main.java Aisha Aloma
Make a UI to read user inputs - main.java

