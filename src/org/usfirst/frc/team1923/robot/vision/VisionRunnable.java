package org.usfirst.frc.team1923.robot.vision;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1923.robot.subsystems.GripPipelineTwo;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionRunnable implements Runnable {

	private VisionThread visionThread;
	private double centerX = 0.0;
	private final Object imgLock = new Object();
	private UsbCamera camera;
	private Mat hslThresholdOutput = new Mat();
	
	public VisionRunnable(UsbCamera camera){
		this.camera = camera;
	}
	

	@Override
	public void run() {
		CvSource outputStream = CameraServer.getInstance().putVideo("HSLOutput", 640, 480);

		//visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {

			// if(visionStart){
			//ArrayList<MatOfPoint> contours = pipeline.filterContoursOutput();//new ArrayList<>();
//			if (!pipeline.filterContoursOutput().isEmpty()) {
//				Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
//				synchronized (imgLock) {
//					setCenterX(r.x + (r.width / 2));
//				}
//			}
			
			//outputStream.putFrame(pipeline.hslThresholdOutput());
			// }
			// else{
		
			 //CvSink cvSink = CameraServer.getInstance().getVideo();
			 Mat source = new Mat();
			 Mat output = new Mat();
			// while(true){
			// cvSink.grabFrame(source);
			 Mat hslThresholdInput = source;
				double[] hslThresholdHue = {86.94758269426634, 98.38127240386027};
				double[] hslThresholdSaturation = {247.6618579287323, 255.0};
				double[] hslThresholdLuminance = {104.83042387653596, 228.89078498293517};
				hslThreshold(hslThresholdInput, hslThresholdHue, hslThresholdSaturation, hslThresholdLuminance, output);

			 outputStream.putFrame(output);
		}
			 

			// Mat hslThresholdInput = source0;
			// double[] hslThresholdHue = {86.94758269426634,
			// 98.38127240386027};
			// double[] hslThresholdSaturation = {247.6618579287323, 255.0};
			// double[] hslThresholdLuminance = {104.83042387653596,
			// 228.89078498293517};
			// hslThreshold(hslThresholdInput, hslThresholdHue,
			// hslThresholdSaturation, hslThresholdLuminance,
			// hslThresholdOutput);

		

		//);
		//}
		//visionThread.start();

		// CvSink cvSink = CameraServer.getInstance().getVideo();
		// CvSource outputStream =
		// CameraServer.getInstance().putVideo("Blur", 640, 480);
		//
		// Mat source = new Mat();
		// Mat output = new Mat();
		//
		// while(true) {
		// cvSink.grabFrame(source);
		// Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
		// outputStream.putFrame(output);
		// }

//	}


	private void setCenterX(int i) {
		centerX = i;
		
	}
	
	private void hslThreshold(Mat input, double[] hue, double[] sat, double[] lum,
			Mat out) {
			Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HLS);
			Core.inRange(out, new Scalar(hue[0], lum[0], sat[0]),
				new Scalar(hue[1], lum[1], sat[1]), out);
	}


	public double getCenterX() {
		return centerX;
	}

}
