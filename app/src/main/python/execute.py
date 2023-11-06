import pickle
from os.path import dirname, join

def RBCCerdos(input):
    filename = join(dirname(__file__), "pigsKnn_model")
    loaded_model = pickle.load(open(filename, "rb"))
    respuestas = [int(segment) for segment in input.split(":") if segment]
    print(respuestas)
    result = loaded_model.predict([respuestas])
    return result
