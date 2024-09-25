# Development of Train Conflict Prevention System Using Object Enhanced Time Petri Nets

This project focuses on the development of a **Train Conflict Prevention System** using **Object Enhanced Time Petri Nets (OETPNs)**. The system aims to prevent collisions between trains by adjusting departure times and controlling signal lights at stations and intersections.

## Project Objective

The objective of this project is to enhance the safety and efficiency of railway operations by:

- **Train Conflict Detection**: Identifying potential train conflicts at stations and intersections based on factors like train length, platform availability, train speeds, and scheduled departure times.
- **Departure Time Adjustment**: Dynamically adjusting train departure times to prevent conflicts between incoming and outgoing trains.
- **Signal Light Control**: Automatically controlling signal lights at stations and interlocking points on the main railway to ensure safe entry and exit of trains.

## System Components

The system includes the following components:

- **Supervisors (A, B, C)**: These components manage train schedules and platform assignments.
- **Stations (A, B, C)**: Handle train arrivals and departures at each station.
- **Controllers (L1, L2, etc.)**: Manage signal lights at stations and on the main railway to prevent collisions.
- **Main Railway**: Coordinates train movements between stations.

## Algorithms

The system utilizes several algorithms to manage train schedules and ensure safety:

- **Train Scheduling**: Dynamically adjusts departure times to prevent conflicts at stations and intersections.
- **Signal Light Control**: Manages signal timings, calculating when signal lights should turn red to ensure safe train movement.
- **Collision Detection**: Identifies potential collisions based on real-time data such as train speed, length, and platform availability.

## Technology Stack

- **Object Enhanced Time Petri Nets (OETPNs)**: Used for modeling and managing the railway system's dynamic behaviors.
- **Java**: Used for implementing the train conflict prevention system, providing flexibility and robustness.

## Results

Key outcomes from this project include:

- **Accurate Train Scheduling**: Successfully schedules trains based on real-time data, preventing conflicts.
- **Effective Signal Light Control**: Computes red light timings for signal lights, ensuring safe train entries and exits.
- **Collision Prevention**: Ensures that a train departs only when another train is at a safe distance.

## How It Works

1. **Train Detection**: Detects trains approaching stations or intersections based on sensor inputs.
2. **Conflict Detection**: Adjusts departure times dynamically if a potential conflict is detected.
3. **Signal Control**: Automatically adjusts signal lights to manage safe train movement.

## Testing and Validation

The system has been rigorously tested to ensure:

- **Safe Train Movements**: Trains depart only when a safe distance from other trains is ensured.
- **Accurate Signal Control**: Signal timings are calculate, ensuring safety at stations and intersections.


