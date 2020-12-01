# This files contains your custom actions which can be used to run
# custom Python code.
#
# See this guide on how to implement these action:
# https://rasa.com/docs/rasa/core/actions/#custom-actions/


# This is a simple example for a custom action which utters "Hello World!"

# from typing import Any, Text, Dict, List
#
# from rasa_sdk import Action, Tracker
# from rasa_sdk.executor import CollectingDispatcher
#
#
# class ActionHelloWorld(Action):
#
#     def name(self) -> Text:
#         return "action_hello_world"
#
#     def run(self, dispatcher: CollectingDispatcher,
#             tracker: Tracker,
#             domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
#
#         dispatcher.utter_message("Hello World!")
#
#         return []
from typing import Dict, Text, Any, List, Union, Optional

from rasa_sdk import ActionExecutionRejection
from rasa_sdk import Action
from rasa_sdk import Tracker
from rasa_sdk.events import SlotSet
from rasa_sdk.executor import CollectingDispatcher
from rasa_sdk.forms import FormAction, REQUESTED_SLOT
from duckling import DucklingWrapper, Dim, Language
import time
import requests

d = DucklingWrapper()
def time_validate(value:Text):
	parses = d.parse_time(value)
	for parse in parses:
		if parse ['dim'] == 'time':
			if parse['value'].get('grain') == 'minute' or parse['value'].get('grain') == 'hour': 
				return parse ['value']['value']
	return None
	
def date_validate(value:Text):
		parses = d.parse_time(value)
		for parse in parses:
			if parse ['dim'] == 'time':
				if parse['value'].get('grain') == 'day' or parse['value'].get('grain') == 'month' or parse['value'].get('grain') == 'year': 
					return parse ['value']['value']
		return None
		
transmission_db={
	"manual":["manual","manual"," manual of arms"],
	"automatic":["automatic","automatic rifle"," automatic"," machine rifle"," automatic pistol"," automatonlike"," machinelike"," robotlike"," robotic"," reflex"," reflexive"],
}

def transmission_validate(value:Text):
	for input in transmission_db:
		if value.lower() in transmission_db[input]:
			return input
	return None
entertainment_db={
	"radio":["radio","radio"," radiocommunication"," wireless"," radio receiver"," receiving set"," radio set"," tuner"],
	"cd":["cd","cadmium"," cd"," atomic number 48"," candle"," candela"," cd"," standard candle"," certificate of deposit"," cd"," compact disk"," compact disc"," four hundred"," 400"],
}

def entertainment_validate(value:Text):
	for input in entertainment_db:
		if value.lower() in entertainment_db[input]:
			return input
	return None
	class Select_TransmissionForm (FormAction):
		def name(self):
			# type: () -> Text
			"""Unique identifier of the form"""
		
			return "Select_Transmission_form"
			
		@staticmethod
		def required_slots(tracker: Tracker) -> List[Text]:
			"""A list of required slots that the form has to fill"""
return ["Transmission_type"]

	def validate_Transmission_type(self, value: Text,dispatcher: CollectingDispatcher,tracker: Tracker,domain: Dict[Text, Any]) -> Dict[Text, Any]:
		parseValue = transmission_validate(value)
		if parseValue is None:
			dispatcher.utter_template('utter_wrong_Transmission_type', tracker)
			return {'Transmission_type': None}
		return {'Transmission_type': parseValue}

	def slot_mappings(self):

		return {
		      	"Transmission_type": [self.from_entity(entity="Transmission_type"),self.from_text()],
		      	}
def submit(
    self,
    dispatcher: CollectingDispatcher,
    tracker: Tracker,
    domain: Dict[Text, Any],
) -> List[Dict]:
   """Define what the form has to do
       after all required slots are filled"""
   return []

class Select_TransmissionClean (Action):
	def name(self) -> Text:
		return "Select_Transmission_clean"
	def run(self, dispatcher: CollectingDispatcher,
			tracker: Tracker,
			domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
	return [SlotSet("Transmission_type", None) ]            
	class Select_EntertainmentForm (FormAction):
		def name(self):
			# type: () -> Text
			"""Unique identifier of the form"""
		
			return "Select_Entertainment_form"
			
		@staticmethod
		def required_slots(tracker: Tracker) -> List[Text]:
			"""A list of required slots that the form has to fill"""
return ["Entertainment_type"]

	def validate_Entertainment_type(self, value: Text,dispatcher: CollectingDispatcher,tracker: Tracker,domain: Dict[Text, Any]) -> Dict[Text, Any]:
		parseValue = entertainment_validate(value)
		if parseValue is None:
			dispatcher.utter_template('utter_wrong_Entertainment_type', tracker)
			return {'Entertainment_type': None}
		return {'Entertainment_type': parseValue}

	def slot_mappings(self):

		return {
		      	"Entertainment_type": [self.from_entity(entity="Entertainment_type"),self.from_list()],
		      	}
def submit(
    self,
    dispatcher: CollectingDispatcher,
    tracker: Tracker,
    domain: Dict[Text, Any],
) -> List[Dict]:
   """Define what the form has to do
       after all required slots are filled"""
   return []

class Select_EntertainmentClean (Action):
	def name(self) -> Text:
		return "Select_Entertainment_clean"
	def run(self, dispatcher: CollectingDispatcher,
			tracker: Tracker,
			domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
	return [SlotSet("Entertainment_type", None) ]            











