private static List<Integer> getListOfDuplicatesElements(){
        List<Integer> inputArray = new ArrayList<>();
        inputArray.add(2);
        inputArray.add(3);
        inputArray.add(1);
        inputArray.add(2);
        inputArray.add(4);
        inputArray.add(3);
        Map<Integer, Integer> result = new HashMap<>();
        for (int i=0;i<inputArray.size();i++) {
            if(result.containsKey(inputArray.get(i))){
                int temp = result.get(inputArray.get(i)).intValue();
                temp++;
                result.put(inputArray.get(i), temp);
            } else {
                result.put(inputArray.get(i), 1);
            }
        }
        List<Integer> finalAnswer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if(entry.getValue()>1){
                finalAnswer.add(entry.getKey());
            }
        }
        return finalAnswer;
    }