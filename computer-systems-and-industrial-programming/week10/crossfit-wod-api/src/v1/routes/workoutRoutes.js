// In src/v1/routes/workoutRoutes.js
const express = require("express");
const bodyParser = require("body-parser");
const apicache = require("apicache");


const workoutController = require("../../controllers/workoutController");
const recordController = require("../../controllers/recordController");

const router = express.Router();

const app = express();
const cache = apicache.middleware;

app.use(bodyParser.json());

app.use(cache("2 minutes"));
// app.use("/api/v1/workouts", v1WorkoutRouter);

router.get("/", cache("2 minutes"), workoutController.getAllWorkouts);

router.get("/", workoutController.getAllWorkouts);

router.get("/:workoutId", workoutController.getOneWorkout);
// *** ADD ***
// router.get("/:workoutId/records", recordController.getRecordForWorkout);

router.post("/", workoutController.createNewWorkout);

router.patch("/:workoutId", workoutController.updateOneWorkout);

router.delete("/:workoutId", workoutController.deleteOneWorkout);

module.exports = router;