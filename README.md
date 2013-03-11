the_weather_sound
=================

###Jasper Boyd

__Summary:__ Max/MSP/Jitter Project that converts real time weather data into ambient music. 

__Version:__ 0.0

---

##todo 
	- Sound Synthesizing Engine
	- Wind Synthesizing Engine
	- Precipitation Synthesizing Engine
	
##bugs
	-
	
--- 

##Goal

The major goal behind this project was finding a new way to distribute commonly consumed data. So many people everyday log onto sites like [Wunderground](http://www.wunderground.com) and look at the strings that will explain to them what it's like outside weather-wise. This certainly effectively communicates the data, but what if the process was simpler? What if that data could be communicated by the speaker built into an alarm clock?

##Programming Approach

For the most part my goal is to show the extremes in weather conditions. By taking the data downloaded from [Wunderground](http://www.wunderground.com), and build algorithms that takes there respective peice of the data and use that number to generate the music. 

###Java External:

The first challenge for this project was getting the data into Max/MSP/Jitter.

###Temperature: 

Temperature is a measure of the local thermal energy of matter or radiation (1). Colder temperatures means that the energy is lower whereas hotter temperatures indicate more energy (1). These facts should be  

##Compositional Approach

On the musical end I wanted the music to be generated to be minimalistic. The way that I like to think about it is that the weather is the musician and I am building a custom instrument. To make this instrument I first considered what sort of aspects of the weather that we can hear already. 

I wanted to avoid building something that merely mimics the natural sound of the weather, mainly because I knew it would be too easy to build a program that merely played samples to match the input data. 

I knew that the music would be much more expressive if I created synth engines that were tailored perfectly to the data available.

###Choosing The Notes:

My first choice was to decide what notes we're going to be chosen based on the data. Because of the restrictions on data I didn't want to tie up variables in deciding what key and notes to use for the current weather. This created a problem because I also didn't what to take the easy way out and make everything in a basic key like *C Major*. To solve this problem I came up with the concept of the weather having a mood which would be able to select a key.

###Mood: 

For Version 1 is only going to have two moods __Upset__ and __Content__. __Upset__ will be chosen for weather data that is categorized as *Extreme*, otherwise the modd will be set to __Content__. For the keys that these moods will represent I decided to decide based on the keys I like to use in my own compositions. I chose *C# Minor* as the key to represent __Upset__ weather and *D major* as the key to represent __Content__ weather. 

###Choosing the Sound: 



##Resources

1. [Temperature (Wikipedia)](http://en.wikipedia.org/wiki/Temperature)
2. 

---



