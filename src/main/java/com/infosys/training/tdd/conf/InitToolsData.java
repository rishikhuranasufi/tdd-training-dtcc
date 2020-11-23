package com.infosys.training.tdd.conf;

//@Component("initToolsData")
public class InitToolsData {

    /*public static final String DIRECTORY_NAME = "init";
    @Autowired
    private ToolsConfRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(InitToolsData.class);

    public void init(){
        logger.info("Deleting existing collection");
        repository.deleteAll();
        JSONParser parser = new JSONParser();

        File folder = new File(DIRECTORY_NAME);
        File[] listOfFiles = folder.listFiles();
        logger.info("Files ::::: "+listOfFiles.toString());
        for (File file : listOfFiles != null ? listOfFiles : new File[0]) {
            if (file.isFile()) {
                logger.info("Files ::::: "+file.getName());
                try (Reader reader = new FileReader(DIRECTORY_NAME+"//"+file.getName())) {

                    JSONObject jsonObject = (JSONObject) parser.parse(reader);
                    logger.info(jsonObject.toString());

                    String toolName = (String) jsonObject.get("toolName");
                    logger.info(toolName);

                    ToolConf toolConfObj = new Gson().fromJson(jsonObject.toString(), ToolConf.class);

                    repository.save(toolConfObj);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

    }*/
}
