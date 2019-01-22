package dan.turtle.common;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class TurtleCanvas extends Canvas implements Runnable{
	
	private int width;
	private int height;
	
	private Thread thread;
	private boolean running;
	
	private BufferStrategy bs;
	
	public TurtleCanvas(int width, int height) {
		this.width = width;
		this.height = height;
		
		running = false;
		
		start();
	}
	
	public void start() {
		running = true;
		thread = new Thread(this, "TurtleCoder");
		thread.start();
	}
	
	public void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		final double UPS = 60.0;
		final double UPDATE_TIME = 1000000000.0 / UPS;
		double delta = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / UPDATE_TIME;
			lastTime = now;
			
			while(delta >= 1) {
				delta--;
			}
			
			while(!isDisplayable()) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			render();
			
		}
		stop();
	}
	
	private void render() {
		bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		g.drawRect(10, 10, 100, 100);
		
		g.dispose();
		bs.show();
	}

}
