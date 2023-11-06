import pickle
from os.path import dirname, join

filename = join(dirname(__file__), "pigsKnn_model")

# load the model from disk
loaded_model = pickle.load(open(filename, "rb"))
respuestas = [0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1]
result = loaded_model.predict([respuestas])