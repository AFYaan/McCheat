package net.minecraft.afyaan.modulebase;

public class Timer {
	private long prevTime;
	
	public Timer(){
		this.prevTime = 0L;
	}
	
	public boolean hasTimePassed(long milSec){
		return (float)(getTime() - this.prevTime) >= (float)milSec;
	}
	
	public void reset(){
		this.prevTime = getTime();
	}
	
	public long getTime(){
		return System.nanoTime() / 1000000L;
	}
}