the_weather_sound
=================

###Jasper Boyd

__Summary:__ A computer music project that converts real time weather data into soundscapes. 

__Techonologies:__ Max/MSP/Jitter, Java, JSON

__Version:__ 0.0

---

##todo 
	- Flush out approach
	- Add a copy of the java external source
	- Determine mood from input data
	- Sound Synthesizing Engine
	- Wind Synthesizing Engine
	- Precipitation Synthesizing Engine
	
##bugs
	-
	
--- 

##Outline

	- Base Synth
		- temp_f
		- feelslike_f
		- visibility_mi
		- UV
		- pressure_in
		- pressure_trend
		- dewpoint_f
		- relative_humidity
	
	- Wind Synth
		- wind_degrees
		- wind_mph
		- wind_gust_mph 
	
	- Precipitation Synth
		- temp_f
		- precip_1hr_in
		- precip_today_in
		
	- MoodInterpreter
		- Upset
		- Content

---

###Legend

__bold__ means that it is a definition of my own. 

*italic*  means it is a technical term.

---

##Goal

The major goal behind this project was finding a new way to distribute commonly consumed data. So many people everyday log onto sites like [Wunderground](http://www.wunderground.com) and look at the strings that will explain to them what it's like outside weather-wise. This certainly effectively communicates the data, but what if the process was simpler? What if that data could be communicated by the speaker built into an alarm clock?

##Programming Approach

For the most part my goal is to show the extremes in weather conditions. By taking the data downloaded from [Wunderground](http://www.wunderground.com), and build algorithms that takes there respective peice of the data and use that number to generate the music. 

The best option for answering the problem of accurately articulating extremes in the weather was to use the variables available from the [Wunderground API](http://www.wunderground.com). This lead to the creation of three subsynths __Base__, __Wind__, and __Precipitation__. 

###Base

__Base__ is the predominant sound that the listener is hearing. It contains the main pitch of the current note. It will normally cover the most registers. This sound is going to be composed of the following variables:

	- temp_f
	- feelslike_f
	- visibility_mi
	- UV
	- pressure_in
	- pressure_trend
	- dewpoint_f
	- relative_humidity
	
The majority of these variables control the paremeters of the synth, more details will follow.

###Wind

I like to think of __Wind__ as a kind of auxiliary synth in the program some sort of equivalent to the *"noise"* feature on more vintage affairs. This auxiliary module runs on the following   *JSON* variables:

	- wind_degrees
	- wind_mph
	- wind_gust_mph 
	
The __Wind__ synth would normally not take up as much space on the sound spectrum as __Base__, except for during a major storm or a particularly windy day. 

###Precipitation

The __Precipitation__ synth will only turn on if it's raining or snowing. My main goal with its implementation is to create a clear distinction between weather it is snowing or raining. The variables in use are the following: 

	- temp_f
	- precip_1hr_in
	- precip_today_in
	
Because __Precipitation__ is a major concern with the weather when __Precipitation__ is engaged it causes the entire sound spectrum to be altered.

###Java External:

The first challenge for this project was getting the data into *Max/MSP/Jitter*.

####JSON

*JSON* really made this whole project possible. It was the only real way that I could retrieve that data using Java (The only extension language [Cycling74](http://www.cycling74.com) readily provides).

###Temperature: 

Temperature is a measure of the local thermal energy of matter or radiation. Colder temperatures means that the energy is lower whereas hotter temperatures indicate more energy (1). When I was trying to define the way the temperature would affect the music I wanted to take into consideration the scientific definition in addition to our human perception. To this end I wanted the temperature input to control the __warmth__ and the __energy__ of the music. The __warmth__ parameter would make the sound *thin* when it is cold, and *thick* when it is hot.

###Wind: 

When looking at the values I was going to be able to pull from [Wunderground's](http://www.wunderground.com) servers I was excited when I saw the "wind_degrees" variable. That value was sure to control the stereo imaging of the synthesizer. 

##Compositional Approach

On the musical end I wanted the music to be generated to be minimalistic. The way that I like to think about it is that the weather is the musician and I am building a custom instrument. To make this instrument I first considered what sort of aspects of the weather that we can hear already. 

I wanted to avoid building something that merely mimics the natural sound of the weather, mainly because I knew it would be too easy to build a program that merely played samples to match the input data. 

I knew that the music would be much more expressive if I created synth engines that were tailored perfectly to the data available.  

###Choosing The Notes

My first choice was to decide what notes we're going to be chosen based on the data. Because of the restrictions on data I didn't want to tie up variables in deciding what key and notes to use for the current weather. This created a problem because I also didn't what to take the easy way out and make everything in a basic key like *C Major*. To solve this problem I came up with the concept of the weather having a mood which would be able to select a key.

####Mood: 

For Version 1 is only going to have two moods __Upset__ and __Content__. __Upset__ will be chosen for weather data that is categorized as Extreme, otherwise the modd will be set to __Content__. For the keys that these moods will represent I decided to decide based on the keys I like to use in my own compositions. I chose *C# Minor* as the key to represent __Upset__ weather and *D major* as the key to represent __Content__ weather. 

###Defining the Melody: 

I decided the best way to determine when notes should change is to look at the variables and everytime something changes after retrieving the data from the server the note will change. I designed a custom algorithm to choose which notes will be triggered.



##Resources

1. [Temperature (Wikipedia)](http://en.wikipedia.org/wiki/Temperature)

---



